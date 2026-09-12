package m3;

import android.text.TextUtils;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* loaded from: classes2.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f69246a;

    /* renamed from: b, reason: collision with root package name */
    public final int f69247b;

    /* renamed from: c, reason: collision with root package name */
    public final int f69248c;

    /* renamed from: d, reason: collision with root package name */
    public final int f69249d;

    /* renamed from: e, reason: collision with root package name */
    public final int f69250e;

    private a(int i11, int i12, int i13, int i14, int i15) {
        this.f69246a = i11;
        this.f69247b = i12;
        this.f69248c = i13;
        this.f69249d = i14;
        this.f69250e = i15;
    }

    public static a a(String str) {
        char c11;
        androidx.media3.common.util.a.a(str.startsWith("Format:"));
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
        return new a(i11, i12, i13, i14, split.length);
    }
}
