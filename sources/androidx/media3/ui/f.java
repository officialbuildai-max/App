package androidx.media3.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Locale;

/* loaded from: classes2.dex */
public class f implements z0 {

    /* renamed from: a, reason: collision with root package name */
    private final Resources f13772a;

    public f(Resources resources) {
        this.f13772a = (Resources) androidx.media3.common.util.a.e(resources);
    }

    private String b(androidx.media3.common.r rVar) {
        int i11 = rVar.E;
        return (i11 == -1 || i11 < 1) ? "" : i11 != 1 ? i11 != 2 ? (i11 == 6 || i11 == 7) ? this.f13772a.getString(R$string.exo_track_surround_5_point_1) : i11 != 8 ? this.f13772a.getString(R$string.exo_track_surround) : this.f13772a.getString(R$string.exo_track_surround_7_point_1) : this.f13772a.getString(R$string.exo_track_stereo) : this.f13772a.getString(R$string.exo_track_mono);
    }

    private String c(androidx.media3.common.r rVar) {
        int i11 = rVar.f10238j;
        return i11 == -1 ? "" : this.f13772a.getString(R$string.exo_track_bitrate, Float.valueOf(i11 / 1000000.0f));
    }

    private String d(androidx.media3.common.r rVar) {
        return TextUtils.isEmpty(rVar.f10230b) ? "" : rVar.f10230b;
    }

    private String e(androidx.media3.common.r rVar) {
        String j11 = j(f(rVar), h(rVar));
        return TextUtils.isEmpty(j11) ? d(rVar) : j11;
    }

    private String f(androidx.media3.common.r rVar) {
        String str = rVar.f10232d;
        if (TextUtils.isEmpty(str) || C.LANGUAGE_UNDETERMINED.equals(str)) {
            return "";
        }
        Locale forLanguageTag = Locale.forLanguageTag(str);
        Locale Y = androidx.media3.common.util.a1.Y();
        String displayName = forLanguageTag.getDisplayName(Y);
        if (TextUtils.isEmpty(displayName)) {
            return "";
        }
        try {
            int offsetByCodePoints = displayName.offsetByCodePoints(0, 1);
            return displayName.substring(0, offsetByCodePoints).toUpperCase(Y) + displayName.substring(offsetByCodePoints);
        } catch (IndexOutOfBoundsException unused) {
            return displayName;
        }
    }

    private String g(androidx.media3.common.r rVar) {
        int i11 = rVar.f10250v;
        int i12 = rVar.f10251w;
        return (i11 == -1 || i12 == -1) ? "" : this.f13772a.getString(R$string.exo_track_resolution, Integer.valueOf(i11), Integer.valueOf(i12));
    }

    private String h(androidx.media3.common.r rVar) {
        String string = (rVar.f10234f & 2) != 0 ? this.f13772a.getString(R$string.exo_track_role_alternate) : "";
        if ((rVar.f10234f & 4) != 0) {
            string = j(string, this.f13772a.getString(R$string.exo_track_role_supplementary));
        }
        if ((rVar.f10234f & 8) != 0) {
            string = j(string, this.f13772a.getString(R$string.exo_track_role_commentary));
        }
        return (rVar.f10234f & 1088) != 0 ? j(string, this.f13772a.getString(R$string.exo_track_role_closed_captions)) : string;
    }

    private static int i(androidx.media3.common.r rVar) {
        int k11 = androidx.media3.common.y.k(rVar.f10243o);
        if (k11 != -1) {
            return k11;
        }
        if (androidx.media3.common.y.n(rVar.f10239k) != null) {
            return 2;
        }
        if (androidx.media3.common.y.c(rVar.f10239k) != null) {
            return 1;
        }
        if (rVar.f10250v == -1 && rVar.f10251w == -1) {
            return (rVar.E == -1 && rVar.F == -1) ? -1 : 1;
        }
        return 2;
    }

    private String j(String... strArr) {
        String str = "";
        for (String str2 : strArr) {
            if (str2.length() > 0) {
                str = TextUtils.isEmpty(str) ? str2 : this.f13772a.getString(R$string.exo_item_list, str, str2);
            }
        }
        return str;
    }

    @Override // androidx.media3.ui.z0
    public String a(androidx.media3.common.r rVar) {
        int i11 = i(rVar);
        String j11 = i11 == 2 ? j(h(rVar), g(rVar), c(rVar)) : i11 == 1 ? j(e(rVar), b(rVar), c(rVar)) : e(rVar);
        if (j11.length() != 0) {
            return j11;
        }
        String str = rVar.f10232d;
        return (str == null || str.trim().isEmpty()) ? this.f13772a.getString(R$string.exo_track_unknown) : this.f13772a.getString(R$string.exo_track_unknown_name, str);
    }
}
