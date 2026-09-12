package com.google.android.exoplayer2.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.exoplayer2.o1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Locale;

/* loaded from: classes3.dex */
public class g implements o0 {

    /* renamed from: a, reason: collision with root package name */
    private final Resources f27177a;

    public g(Resources resources) {
        this.f27177a = (Resources) com.google.android.exoplayer2.util.a.e(resources);
    }

    private String b(o1 o1Var) {
        int i11 = o1Var.f25563y;
        return (i11 == -1 || i11 < 1) ? "" : i11 != 1 ? i11 != 2 ? (i11 == 6 || i11 == 7) ? this.f27177a.getString(R$string.exo_track_surround_5_point_1) : i11 != 8 ? this.f27177a.getString(R$string.exo_track_surround) : this.f27177a.getString(R$string.exo_track_surround_7_point_1) : this.f27177a.getString(R$string.exo_track_stereo) : this.f27177a.getString(R$string.exo_track_mono);
    }

    private String c(o1 o1Var) {
        int i11 = o1Var.f25546h;
        return i11 == -1 ? "" : this.f27177a.getString(R$string.exo_track_bitrate, Float.valueOf(i11 / 1000000.0f));
    }

    private String d(o1 o1Var) {
        return TextUtils.isEmpty(o1Var.f25540b) ? "" : o1Var.f25540b;
    }

    private String e(o1 o1Var) {
        String j11 = j(f(o1Var), h(o1Var));
        return TextUtils.isEmpty(j11) ? d(o1Var) : j11;
    }

    private String f(o1 o1Var) {
        String str = o1Var.f25541c;
        if (TextUtils.isEmpty(str) || C.LANGUAGE_UNDETERMINED.equals(str)) {
            return "";
        }
        Locale forLanguageTag = com.google.android.exoplayer2.util.p0.f27680a >= 21 ? Locale.forLanguageTag(str) : new Locale(str);
        Locale R = com.google.android.exoplayer2.util.p0.R();
        String displayName = forLanguageTag.getDisplayName(R);
        if (TextUtils.isEmpty(displayName)) {
            return "";
        }
        try {
            int offsetByCodePoints = displayName.offsetByCodePoints(0, 1);
            String valueOf = String.valueOf(displayName.substring(0, offsetByCodePoints).toUpperCase(R));
            String valueOf2 = String.valueOf(displayName.substring(offsetByCodePoints));
            displayName = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        } catch (IndexOutOfBoundsException unused) {
        }
        return displayName;
    }

    private String g(o1 o1Var) {
        int i11 = o1Var.f25555q;
        int i12 = o1Var.f25556r;
        return (i11 == -1 || i12 == -1) ? "" : this.f27177a.getString(R$string.exo_track_resolution, Integer.valueOf(i11), Integer.valueOf(i12));
    }

    private String h(o1 o1Var) {
        String string = (o1Var.f25543e & 2) != 0 ? this.f27177a.getString(R$string.exo_track_role_alternate) : "";
        if ((o1Var.f25543e & 4) != 0) {
            string = j(string, this.f27177a.getString(R$string.exo_track_role_supplementary));
        }
        if ((o1Var.f25543e & 8) != 0) {
            string = j(string, this.f27177a.getString(R$string.exo_track_role_commentary));
        }
        return (o1Var.f25543e & 1088) != 0 ? j(string, this.f27177a.getString(R$string.exo_track_role_closed_captions)) : string;
    }

    private static int i(o1 o1Var) {
        int l11 = com.google.android.exoplayer2.util.w.l(o1Var.f25550l);
        if (l11 != -1) {
            return l11;
        }
        if (com.google.android.exoplayer2.util.w.o(o1Var.f25547i) != null) {
            return 2;
        }
        if (com.google.android.exoplayer2.util.w.c(o1Var.f25547i) != null) {
            return 1;
        }
        if (o1Var.f25555q == -1 && o1Var.f25556r == -1) {
            return (o1Var.f25563y == -1 && o1Var.f25564z == -1) ? -1 : 1;
        }
        return 2;
    }

    private String j(String... strArr) {
        String str = "";
        for (String str2 : strArr) {
            if (str2.length() > 0) {
                str = TextUtils.isEmpty(str) ? str2 : this.f27177a.getString(R$string.exo_item_list, str, str2);
            }
        }
        return str;
    }

    @Override // com.google.android.exoplayer2.ui.o0
    public String a(o1 o1Var) {
        int i11 = i(o1Var);
        String j11 = i11 == 2 ? j(h(o1Var), g(o1Var), c(o1Var)) : i11 == 1 ? j(e(o1Var), b(o1Var), c(o1Var)) : e(o1Var);
        return j11.length() == 0 ? this.f27177a.getString(R$string.exo_track_unknown) : j11;
    }
}
