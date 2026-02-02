package org.yevhenstadnik.newinjava.java17;

public class TextBlockJava15 {
    public static void main(String[] args) {
        String json = """
                {
                    "name": "John",     // Comments inside text blocks /* are not hidden */
                    "age": 30,/n /r /t  // Control characters inside text blocks are not hidden
                    'city': "New York"  // Single and double quotes are allowed " without escaping
                    "skills": [         // Backslashes terminates new lines \
                        "Java", \
                        "Python", \
                        "JavaScript" \
                    ]
                }
                """; // Trailing quotes must be on a new line if you need a /n at the end

//        String json2 = """ Compilation error: Leading quotes must be on a new line
//                """;

        CharSequence cs = """
                This is a CharSequence text block.
                It can be assigned to any variable of type CharSequence."""; // If you do not need a /n at the end, closing quotes can be on the same line

//        StringBuilder sb = """
//                """; // Compilation error: Cannot assign text block to StringBuilder

        System.out.println(json);
        System.out.println(cs);
    }
}
