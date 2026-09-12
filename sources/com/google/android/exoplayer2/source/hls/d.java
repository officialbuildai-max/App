package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.w;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import e9.u1;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import q9.h0;

/* loaded from: classes3.dex */
public final class d implements g {

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f25998d = {8, 13, 11, 2, 0, 1, 7};

    /* renamed from: b, reason: collision with root package name */
    private final int f25999b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f26000c;

    public d() {
        this(0, true);
    }

    public d(int i11, boolean z10) {
        this.f25999b = i11;
        this.f26000c = z10;
    }

    private static void b(int i11, List list) {
        if (Ints.j(f25998d, i11) == -1 || list.contains(Integer.valueOf(i11))) {
            return;
        }
        list.add(Integer.valueOf(i11));
    }

    private g9.l d(int i11, o1 o1Var, List list, l0 l0Var) {
        if (i11 == 0) {
            return new q9.b();
        }
        if (i11 == 1) {
            return new q9.e();
        }
        if (i11 == 2) {
            return new q9.h();
        }
        if (i11 == 7) {
            return new n9.f(0, 0L);
        }
        if (i11 == 8) {
            return e(l0Var, o1Var, list);
        }
        if (i11 == 11) {
            return f(this.f25999b, this.f26000c, o1Var, list, l0Var);
        }
        if (i11 != 13) {
            return null;
        }
        return new r(o1Var.f25541c, l0Var);
    }

    private static o9.g e(l0 l0Var, o1 o1Var, List list) {
        int i11 = g(o1Var) ? 4 : 0;
        if (list == null) {
            list = Collections.emptyList();
        }
        return new o9.g(i11, l0Var, null, list);
    }

    private static h0 f(int i11, boolean z10, o1 o1Var, List list, l0 l0Var) {
        int i12 = i11 | 16;
        if (list != null) {
            i12 = i11 | 48;
        } else {
            list = z10 ? Collections.singletonList(new o1.b().e0(MimeTypes.APPLICATION_CEA608).E()) : Collections.emptyList();
        }
        String str = o1Var.f25547i;
        if (!TextUtils.isEmpty(str)) {
            if (!w.b(str, MimeTypes.AUDIO_AAC)) {
                i12 |= 2;
            }
            if (!w.b(str, MimeTypes.VIDEO_H264)) {
                i12 |= 4;
            }
        }
        return new h0(2, l0Var, new q9.j(i12, list));
    }

    private static boolean g(o1 o1Var) {
        Metadata metadata = o1Var.f25548j;
        if (metadata == null) {
            return false;
        }
        for (int i11 = 0; i11 < metadata.length(); i11++) {
            if (metadata.get(i11) instanceof HlsTrackMetadataEntry) {
                return !((HlsTrackMetadataEntry) r2).variantInfos.isEmpty();
            }
        }
        return false;
    }

    private static boolean h(g9.l lVar, g9.m mVar) {
        try {
            boolean d11 = lVar.d(mVar);
            mVar.resetPeekPosition();
            return d11;
        } catch (EOFException unused) {
            mVar.resetPeekPosition();
            return false;
        } catch (Throwable th2) {
            mVar.resetPeekPosition();
            throw th2;
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b a(Uri uri, o1 o1Var, List list, l0 l0Var, Map map, g9.m mVar, u1 u1Var) {
        int a11 = com.google.android.exoplayer2.util.l.a(o1Var.f25550l);
        int b11 = com.google.android.exoplayer2.util.l.b(map);
        int c11 = com.google.android.exoplayer2.util.l.c(uri);
        int[] iArr = f25998d;
        ArrayList arrayList = new ArrayList(iArr.length);
        b(a11, arrayList);
        b(b11, arrayList);
        b(c11, arrayList);
        for (int i11 : iArr) {
            b(i11, arrayList);
        }
        mVar.resetPeekPosition();
        g9.l lVar = null;
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            int intValue = ((Integer) arrayList.get(i12)).intValue();
            g9.l lVar2 = (g9.l) com.google.android.exoplayer2.util.a.e(d(intValue, o1Var, list, l0Var));
            if (h(lVar2, mVar)) {
                return new b(lVar2, o1Var, l0Var);
            }
            if (lVar == null && (intValue == a11 || intValue == b11 || intValue == c11 || intValue == 11)) {
                lVar = lVar2;
            }
        }
        return new b((g9.l) com.google.android.exoplayer2.util.a.e(lVar), o1Var, l0Var);
    }
}
