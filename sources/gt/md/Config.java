package gt.md;

import android.widget.ImageView;
import androidx.core.C0078;
import androidx.core.C0079;
import androidx.core.appcompat.C0066;
import com.transsion.subroom.activity.C0667;
import com.transsion.subroom.premium.C0669;
import com.transsion.subroom.premium.C0670;
import com.transsion.subroom.premium.C0678;
import java.io.PrintStream;

/* loaded from: classes7.dex */
public class Config {
    public static String backgroundColor = null;
    public static int cornerRadius = 20;
    public static int duration = 1;
    public static String image = null;
    public static int imageHeight = 600;
    public static ImageView.ScaleType imageScaleType = null;
    public static boolean isBold = true;
    public static boolean isItalic = true;
    public static String message = null;

    /* renamed from: short, reason: not valid java name */
    private static final short[] f66short;
    public static String textColor = null;
    public static int textSize = 14;

    /* JADX WARN: Code restructure failed: missing block: B:140:0x0483, code lost:
    
        return;
     */
    static {
        /*
            Method dump skipped, instructions count: 1284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: gt.md.Config.<clinit>():void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0013. Please report as an issue. */
    public Config() {
        float f11 = 0.0f;
        Object obj = "ۨۤۨ";
        while (true) {
            switch (C0799.m1158(obj) ^ 1747682) {
                case 3425:
                    break;
                case 3557:
                    float floatValue = ((Float) C0669.n(92531, null, new Object[]{(String) C0678.n(49534, null, new Object[]{(String) C0670.n(99687)})})).floatValue();
                    if (C0079.m394() >= 0) {
                        C0799.m1162();
                        f11 = floatValue;
                        obj = "ۣۢۡ";
                    } else {
                        f11 = floatValue;
                        obj = "ۧۦ۠";
                    }
                case 25486:
                    if (((Integer) C0678.n(78728, null, new Object[0])).intValue() < 0) {
                        obj = "ۣ۟ۧ";
                    } else if (C0799.m1162() <= 0) {
                        C0799.m1162();
                    } else {
                        obj = "۟۟ۧ";
                    }
                case 27395:
                    obj = "ۨۤۨ";
                case 28419:
                    C0669.n(76004, (PrintStream) C0678.n(82094), new Object[]{Float.valueOf(f11)});
                    obj = "ۣ۟ۧ";
                case 1734301:
                    obj = "ۣ۟ۧ";
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
    /* renamed from: ۟ۥۨۧۢ, reason: not valid java name and contains not printable characters */
    public static short[] m1105() {
        String str = "ۣۨۢ";
        short[] sArr = null;
        short[] sArr2 = null;
        while (true) {
            switch (C0799.m1158((Object) str) ^ 1750690) {
                case 99:
                case 7867:
                    str = C0078.m391() >= 0 ? "ۡۡ۟" : "ۧۧ";
                case 1034:
                    short[] sArr3 = (short[]) C0670.n(91661);
                    if (C0066.m207() != 0) {
                        C0079.m394();
                        str = "ۢ۟ۧ";
                        sArr2 = sArr3;
                    } else {
                        str = "ۡۨ";
                        sArr2 = sArr3;
                    }
                case 1118:
                    str = "۟ۢۡ";
                case 3910:
                    str = "ۧ۠ۧ";
                    sArr = null;
                case 4604:
                    if (C0066.m207() == 0) {
                        str = "ۤ۠۠";
                    }
                case 7541:
                    if (C0799.m1162() <= 0) {
                        C0078.m391();
                    } else {
                        str = "ۣۨۢ";
                    }
                case 29580:
                    str = C0799.m1162() <= 0 ? "ۣ۟ۡ" : "ۣۥۣ";
                case 32651:
                    if (((Integer) C0670.n(67235, null, new Object[0])).intValue() <= 0) {
                        str = "۟ۢۡ";
                    } else if (C0066.m207() == 0) {
                        str = "ۢۢۨ";
                    }
                case 1731138:
                    break;
                case 1731205:
                    if (C0667.m874() >= 0) {
                        sArr = sArr2;
                    } else {
                        str = "ۧۧ";
                        sArr = sArr2;
                    }
            }
            return sArr;
        }
    }
}
