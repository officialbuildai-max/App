package ba;

import com.google.android.exoplayer2.o1;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* loaded from: classes3.dex */
public interface k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f16380a = new a();

    /* loaded from: classes3.dex */
    class a implements k {
        a() {
        }

        @Override // ba.k
        public boolean a(o1 o1Var) {
            String str = o1Var.f25550l;
            return MimeTypes.TEXT_VTT.equals(str) || MimeTypes.TEXT_SSA.equals(str) || MimeTypes.APPLICATION_TTML.equals(str) || MimeTypes.APPLICATION_MP4VTT.equals(str) || MimeTypes.APPLICATION_SUBRIP.equals(str) || MimeTypes.APPLICATION_TX3G.equals(str) || MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_MP4CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str) || MimeTypes.APPLICATION_DVBSUBS.equals(str) || MimeTypes.APPLICATION_PGS.equals(str) || "text/x-exoplayer-cues".equals(str);
        }

        @Override // ba.k
        public j b(o1 o1Var) {
            String str = o1Var.f25550l;
            if (str != null) {
                char c11 = 65535;
                switch (str.hashCode()) {
                    case -1351681404:
                        if (str.equals(MimeTypes.APPLICATION_DVBSUBS)) {
                            c11 = 0;
                            break;
                        }
                        break;
                    case -1248334819:
                        if (str.equals(MimeTypes.APPLICATION_PGS)) {
                            c11 = 1;
                            break;
                        }
                        break;
                    case -1026075066:
                        if (str.equals(MimeTypes.APPLICATION_MP4VTT)) {
                            c11 = 2;
                            break;
                        }
                        break;
                    case -1004728940:
                        if (str.equals(MimeTypes.TEXT_VTT)) {
                            c11 = 3;
                            break;
                        }
                        break;
                    case 691401887:
                        if (str.equals(MimeTypes.APPLICATION_TX3G)) {
                            c11 = 4;
                            break;
                        }
                        break;
                    case 822864842:
                        if (str.equals(MimeTypes.TEXT_SSA)) {
                            c11 = 5;
                            break;
                        }
                        break;
                    case 930165504:
                        if (str.equals(MimeTypes.APPLICATION_MP4CEA608)) {
                            c11 = 6;
                            break;
                        }
                        break;
                    case 1201784583:
                        if (str.equals("text/x-exoplayer-cues")) {
                            c11 = 7;
                            break;
                        }
                        break;
                    case 1566015601:
                        if (str.equals(MimeTypes.APPLICATION_CEA608)) {
                            c11 = '\b';
                            break;
                        }
                        break;
                    case 1566016562:
                        if (str.equals(MimeTypes.APPLICATION_CEA708)) {
                            c11 = '\t';
                            break;
                        }
                        break;
                    case 1668750253:
                        if (str.equals(MimeTypes.APPLICATION_SUBRIP)) {
                            c11 = '\n';
                            break;
                        }
                        break;
                    case 1693976202:
                        if (str.equals(MimeTypes.APPLICATION_TTML)) {
                            c11 = 11;
                            break;
                        }
                        break;
                }
                switch (c11) {
                    case 0:
                        return new da.a(o1Var.f25552n);
                    case 1:
                        return new ea.a();
                    case 2:
                        return new ka.a();
                    case 3:
                        return new ka.h();
                    case 4:
                        return new ja.a(o1Var.f25552n);
                    case 5:
                        return new ga.a(o1Var.f25552n);
                    case 6:
                    case '\b':
                        return new ca.a(str, o1Var.D, 16000L);
                    case 7:
                        return new g();
                    case '\t':
                        return new ca.c(o1Var.D, o1Var.f25552n);
                    case '\n':
                        return new ha.a();
                    case 11:
                        return new ia.c();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    }

    boolean a(o1 o1Var);

    j b(o1 o1Var);
}
