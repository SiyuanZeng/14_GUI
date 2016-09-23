package zeng.siyuan.autohotkey;
// All depends can be found here: http://apps.aboutscript.com/jhk/JHK.zip
// Video: http://youtu.be/EX0iT0NTTjw

    import com.eaio.nativecall.*;

public class AutoHotkeyTest {
    private static IntCall exec;

    public static void main(String[] args) {
        System.out.println("Hello World");


        try {
            NativeCall.init();
            init();
        } catch (Throwable t) {
            System.out.println("\n" + "Something went wrong...");
            System.out.println(t);
        }

        ahk("Run Calc");
        System.out.println("This is the good part!");
        ahk("\n Sleep 1000\n SendInput 1{+}1{Enter}");
        System.out.println("Woo!");
        ahk("Sleep 3000\n WinClose Calc");
    }

    public static void init() {
        IntCall textdll = new IntCall("AutoHotkey.dll", "ahktextdll");
        textdll.executeCall(new Object[]{"", "", ""});

        exec = new IntCall("AutoHotkey.dll", "ahkExec");
    }

    public static void ahk(String code) {
        exec.executeCall(code);
    }
}