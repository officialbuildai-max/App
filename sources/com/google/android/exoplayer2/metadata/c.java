package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.o1;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* loaded from: classes3.dex */
public interface c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f25471a = new a();

    /* loaded from: classes3.dex */
    class a implements c {
        a() {
        }

        @Override // com.google.android.exoplayer2.metadata.c
        public boolean a(o1 o1Var) {
            String str = o1Var.f25550l;
            return MimeTypes.APPLICATION_ID3.equals(str) || MimeTypes.APPLICATION_EMSG.equals(str) || MimeTypes.APPLICATION_SCTE35.equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
        }

        @Override // com.google.android.exoplayer2.metadata.c
        public b b(o1 o1Var) {
            String str = o1Var.f25550l;
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
                        return new s9.a();
                    case 1:
                        return new com.google.android.exoplayer2.metadata.icy.a();
                    case 2:
                        return new com.google.android.exoplayer2.metadata.id3.b();
                    case 3:
                        return new com.google.android.exoplayer2.metadata.emsg.a();
                    case 4:
                        return new com.google.android.exoplayer2.metadata.scte35.a();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    }

    boolean a(o1 o1Var);

    b b(o1 o1Var);
}
