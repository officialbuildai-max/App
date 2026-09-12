package e2;

import androidx.media3.common.r;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import z2.h;

/* loaded from: classes2.dex */
public interface a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f61611a = new C0766a();

    /* renamed from: e2.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0766a implements a {
        C0766a() {
        }

        @Override // e2.a
        public boolean a(r rVar) {
            String str = rVar.f10243o;
            return MimeTypes.APPLICATION_ID3.equals(str) || MimeTypes.APPLICATION_EMSG.equals(str) || MimeTypes.APPLICATION_SCTE35.equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
        }

        @Override // e2.a
        public u2.a b(r rVar) {
            String str = rVar.f10243o;
            if (str != null) {
                char c11 = 65535;
                switch (str.hashCode()) {
                    case -1354451219:
                        if (str.equals("application/vnd.dvb.ait")) {
                            c11 = 0;
                            break;
                        }
                        break;
                    case -1348231605:
                        if (str.equals("application/x-icy")) {
                            c11 = 1;
                            break;
                        }
                        break;
                    case -1248341703:
                        if (str.equals(MimeTypes.APPLICATION_ID3)) {
                            c11 = 2;
                            break;
                        }
                        break;
                    case 1154383568:
                        if (str.equals(MimeTypes.APPLICATION_EMSG)) {
                            c11 = 3;
                            break;
                        }
                        break;
                    case 1652648887:
                        if (str.equals(MimeTypes.APPLICATION_SCTE35)) {
                            c11 = 4;
                            break;
                        }
                        break;
                }
                switch (c11) {
                    case 0:
                        return new v2.b();
                    case 1:
                        return new y2.a();
                    case 2:
                        return new h();
                    case 3:
                        return new w2.b();
                    case 4:
                        return new b3.c();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    }

    boolean a(r rVar);

    u2.a b(r rVar);
}
