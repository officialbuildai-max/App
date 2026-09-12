package androidx.core.appcompat;

import com.transsion.subroom.activity.C0667;
import com.transsion.subroom.premium.C0678;
import gt.md.C0799;
import java.io.PrintStream;

/* loaded from: classes7.dex */
public class thg {
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0012. Please report as an issue. */
    public thg() {
        String str = "ۣ۟ۡ";
        Long l11 = null;
        while (true) {
            switch (C0799.m1158((Object) str) ^ 1750787) {
                case 262:
                    if (((Integer) C0678.n(96887, null, new Object[0])).intValue() > 0) {
                        str = "ۧۧ";
                    } else if (C0799.m1162() > 0) {
                        str = "ۣۥۡ";
                    }
                case 296:
                    if (C0799.m1162() > 0) {
                        str = "ۣ۟ۡ";
                    }
                case 444:
                    Long l12 = (Long) C0678.n(58394, null, new Object[]{(String) C0678.n(66211, null, new Object[]{(String) C0678.n(86831)})});
                    if (C0066.m207() != 0) {
                        str = "ۣ۟ۡ";
                        l11 = l12;
                    } else {
                        str = "ۥۨ۟";
                        l11 = l12;
                    }
                case 1469:
                    str = "ۧۧ";
                case 2463:
                    C0678.n(5185, (PrintStream) C0678.n(82094), new Object[]{l11});
                    if (C0667.m874() < 0) {
                        str = "ۧۧ";
                    }
                case 1731555:
                    break;
            }
            return;
        }
    }

    public static int getButtonCornerRadius() {
        return 10;
    }

    public static int getButtonMargin() {
        return 8;
    }

    public static int getButtonTextSize() {
        return 16;
    }

    public static int getCornerRadius() {
        return 16;
    }

    public static int getIconBorder() {
        return 5;
    }

    public static int getIconMargin() {
        return 6;
    }

    public static int getIconSize() {
        return 60;
    }

    public static int getMessagePadding() {
        return 8;
    }

    public static int getMessageTextSize() {
        return 16;
    }

    public static int getPadding() {
        return 10;
    }

    public static int getSeparatorSize() {
        return 3;
    }

    public static int getStrokeSize() {
        return 1;
    }

    public static int getSubtitleTextSize() {
        return 14;
    }

    public static int getSwitchCornerRadius() {
        return 20;
    }

    public static int getSwitchPadding() {
        return 6;
    }

    public static int getSwitchTextSize() {
        return 14;
    }

    public static int getTitlePadding() {
        return 8;
    }

    public static int getTitleTextSize() {
        return 20;
    }
}
