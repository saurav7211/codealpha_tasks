import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class AiChatBot {
    // FAQ database mapping keywords/patterns to responses
    private final Map<String, String> faqDatabase = new HashMap<>();

    // GUI Components
    private JTextArea chatArea;
    private JTextField inputField;

    public AiChatBot() {
        initializeFAQs();
        setupGUI();
    }

    // Train the bot with frequently asked questions/keywords
    private void initializeFAQs() {
        faqDatabase.put("hello", "Hi there! I am your AI assistant. How can I help you today?");
        faqDatabase.put("hi", "Hello! Hope you are having a great day. What can I do for you?");
        faqDatabase.put("how are you", "I'm just a bundle of Java code, but I'm running perfectly! How are you?");
        faqDatabase.put("name", "I am a Java-based AI Chatbot built for interactive communication.");
        faqDatabase.put("help", "You can ask me about my name, how I work, or just say hello!");
        faqDatabase.put("bye", "Goodbye! Have a wonderful day ahead!");
        faqDatabase.put("java", "Java is a versatile, object-oriented programming language. I love it!");
    }

    private void setupGUI() {
        // Main window configuration
        JFrame frame = new JFrame("AI Chatbot Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout(10, 10));

        // 1. Chat Log Area (Center)
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 14));
        chatArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Add greeting on startup
        chatArea.append("Bot: Hello! Type something to start chatting.\n");

        JScrollPane scrollPane = new JScrollPane(chatArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // 2. Input Panel (Bottom)
        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));
        inputPanel.add(inputField, BorderLayout.CENTER);

        JButton sendButton = new JButton("Send");
        inputPanel.add(sendButton, BorderLayout.EAST);

        frame.add(inputPanel, BorderLayout.SOUTH);

        // --- Action Listeners ---
        // Send message when clicking the button
        sendButton.addActionListener(e -> processUserMessage());
        
        // Send message when pressing 'Enter' key in text field
        inputField.addActionListener(e -> processUserMessage());

        // Center window on screen and display
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // NLP and Rule-Based Matching Logic
    private void processUserMessage() {
        String userText = inputField.getText().trim();
        if (userText.isEmpty()) return;

        // Display user message in chat log
        chatArea.append("You: " + userText + "\n");
        inputField.setText(""); // Clear input bar

        // Basic NLP: Normalize input text (lowercasing)
        String cleanedInput = userText.toLowerCase();

        // Machine Learning/Rule-Based Response generation
        String botResponse = generateFallbackResponse(cleanedInput);
        
        for (Map.Entry<String, String> entry : faqDatabase.entrySet()) {
            // Check if user input contains any of our trained keywords
            if (cleanedInput.contains(entry.getKey())) {
                botResponse = entry.getValue();
                break;
            }
        }

        // Display bot response
        chatArea.append("Bot: " + botResponse + "\n\n");
    }

    // Default rule-based handler when no exact FAQ match is found
    private String generateFallbackResponse(String input) {
        if (input.contains("?") && input.length() > 10) {
            return "That sounds like an interesting question! I don't have the exact answer in my FAQ database yet.";
        }
        return "I'm not quite sure I understand. Could you try asking in a different way, or type 'help'?";
    }

    public static void main(String[] args) {
        // Run GUI thread safely
        SwingUtilities.invokeLater(AiChatBot::new);
    }
}