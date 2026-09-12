package i2;

import androidx.media3.common.r;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import i3.l;
import i3.s;
import java.util.Objects;

/* loaded from: classes2.dex */
public interface g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f65008a = new a();

    /* loaded from: classes2.dex */
    class a implements g {

        /* renamed from: b, reason: collision with root package name */
        private final i3.h f65009b = new i3.h();

        a() {
        }

        @Override // i2.g
        public boolean a(r rVar) {
            String str = rVar.f10243o;
            return this.f65009b.a(rVar) || Objects.equals(str, MimeTypes.APPLICATION_CEA608) || Objects.equals(str, MimeTypes.APPLICATION_MP4CEA608) || Objects.equals(str, MimeTypes.APPLICATION_CEA708);
        }

        @Override // i2.g
        public l b(r rVar) {
            String str = rVar.f10243o;
            if (str != null) {
                char c11 = 65535;
                switch (str.hashCode()) {
                    case 930165504:
                        if (str.equals(MimeTypes.APPLICATION_MP4CEA608)) {
                            c11 = 0;
                            break;
                        }
                        break;
                    case 1566015601:
                        if (str.equals(MimeTypes.APPLICATION_CEA608)) {
                            c11 = 1;
                            break;
                        }
                        break;
                    case 1566016562:
                        if (str.equals(MimeTypes.APPLICATION_CEA708)) {
                            c11 = 2;
                            break;
                        }
                        break;
                }
                switch (c11) {
                    case 0:
                    case 1:
                        return new j3.a(str, rVar.J, 16000L);
                    case 2:
                        return new j3.c(rVar.J, rVar.f10246r);
                }
            }
            if (!this.f65009b.a(rVar)) {
                throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
            }
            s c12 = this.f65009b.c(rVar);
            return new b(c12.getClass().getSimpleName() + "Decoder", c12);
        }
    }

    boolean a(r rVar);

    l b(r rVar);
}
