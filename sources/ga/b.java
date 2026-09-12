package ga;

import android.text.TextUtils;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* loaded from: classes4.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f63611a;

    /* renamed from: b, reason: collision with root package name */
    public final int f63612b;

    /* renamed from: c, reason: collision with root package name */
    public final int f63613c;

    /* renamed from: d, reason: collision with root package name */
    public final int f63614d;

    /* renamed from: e, reason: collision with root package name */
    public final int f63615e;

    private b(int i11, int i12, int i13, int i14, int i15) {
        this.f63611a = i11;
        this.f63612b = i12;
        this.f63613c = i13;
        this.f63614d = i14;
        this.f63615e = i15;
    }

    public static b a(String str) {
        char c11;
        com.google.android.exoplayer2.util.a.a(str.startsWith("Format:"));
        String[] split = TextUtils.split(str.substring(7), ",");
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        int i14 = -1;
        for (int i15 = 0; i15 < split.length; i15++) {
            String e11 = com.google.common.base.a.e(split[i15].trim());
            e11.hashCode();
            switch (e11.hashCode()) {
                case 100571:
                    if (e11.equals(TtmlNode.END)) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 3556653:
                    if (e11.equals(MimeTypes.BASE_TYPE_TEXT)) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 109757538:
                    if (e11.equals("start")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 109780401:
                    if (e11.equals(TtmlNode.TAG_STYLE)) {
                        c11 = 3;
                        break;
                    }
                    break;
            }
            c11 = 65535;
            switch (c11) {
                case 0:
                    i12 = i15;
                    break;
                case 1:
                    i14 = i15;
                    break;
                case 2:
                    i11 = i15;
                    break;
                case 3:
                    i13 = i15;
                    break;
            }
        }
        if (i11 == -1 || i12 == -1 || i14 == -1) {
            return null;
        }
        return new b(i11, i12, i13, i14, split.length);
    }
}
