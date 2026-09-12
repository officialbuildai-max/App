package z9;

import com.google.android.exoplayer2.source.rtsp.j;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* loaded from: classes4.dex */
public final class a {
    public e a(j jVar) {
        String str = (String) com.google.android.exoplayer2.util.a.e(jVar.f26485c.f25550l);
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -53558318:
                if (str.equals(MimeTypes.AUDIO_AAC)) {
                    c11 = 0;
                    break;
                }
                break;
            case 187078296:
                if (str.equals(MimeTypes.AUDIO_AC3)) {
                    c11 = 1;
                    break;
                }
                break;
            case 1331836730:
                if (str.equals(MimeTypes.VIDEO_H264)) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return new b(jVar);
            case 1:
                return new c(jVar);
            case 2:
                return new d(jVar);
            default:
                return null;
        }
    }
}
