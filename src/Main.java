import java.io.*;

public class Main {
    private static String digit[] = {"[нН]оль", "[оО]д...?", "[дД]в..?", "[тТ]р..?", "[чЧ]етыр..?",
            "[пП]ят..?", "[шШ]ест..?", "[сС]ем..?", "[вВ]осем..?", "[дД]евят..?" };
    private static String teen[] = {"[дД]есят..?", "[оО]диннадцат..?", "[дД]венадцат..?", "[тТ]ринадцат..?", "[чЧ]етырнадцат..?",
            "[пП]ятнадцат..?", "[шШ]естнадцат..?", "[сС]емнадцат..?", "[вВ]осемнадцат..?", "[дД]евятнадцат..?" };
    private static String ten[] = {"0", "1" , "[дД]вадцат..?", "[тТ]ридцат..?", "[сС]орок.?",
            "[пП]ят[ьи]десят.?.?", "[шШ]ест[ьи]десят.?.?", "[сС]ем[ьи]десят.?.?", "[вВ]осем[ьи]десят.?.?", "[дД]евяност."};
    private static String houndred[] = {"0", "[сС]т..?", "[дД]в[еу].?с.?т.?", "[тТ]р[еёи].?с.?т.?", "[чЧ]етыр[её].?с.?т.?",
            "[пП]ят[иь]с.?т.?", "[шШ]ест[иь]с.?т.?", "[сС]ем[ьи]с.?т.?", "[вВ]осем[ьи]с.?т.?", "[дД]евят[ьи]с.?т.?"};

    private static boolean flag = false;
    private static int num = 0;
    public static void print(String word) {
        for (int i = 0; i < 10; i++) {
            if (word.matches(houndred[i])) {
                num += i * 100;
                flag = true;
                return;
            }
        }
        if (flag) {
            System.out.print(num + " " );
            num = 0;
            flag = false;
        }
        System.out.print(word + " ");
    }

    public static void main(String[] args) {
        File file = new File("file.txt" );
        String line = "Один";
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file), "UTF-8"
                    )
            );
            while ((line = br.readLine()) != null) {
                String word[] = line.split(" " );
                for (int i = 0; i < word.length; i++)
                    print(word[i]);
                System.out.println();
            }
            br.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

