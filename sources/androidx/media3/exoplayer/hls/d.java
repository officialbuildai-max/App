package androidx.media3.exoplayer.hls;

import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.common.r;
import androidx.media3.common.util.p0;
import androidx.media3.common.x;
import androidx.media3.common.y;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import i3.s;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import s3.k0;
import y1.f4;

/* loaded from: classes2.dex */
public final class d implements g {

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f11783f = {8, 13, 11, 2, 0, 1, 7};

    /* renamed from: a, reason: collision with root package name */
    private final int f11784a;

    /* renamed from: b, reason: collision with root package name */
    private s.a f11785b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f11786c;

    /* renamed from: d, reason: collision with root package name */
    private int f11787d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f11788e;

    public d() {
        this(0, true);
    }

    public d(int i11, boolean z10) {
        this.f11784a = i11;
        this.f11788e = z10;
        this.f11785b = new i3.h();
    }

    private static void f(int i11, List list) {
        if (Ints.j(f11783f, i11) == -1 || list.contains(Integer.valueOf(i11))) {
            return;
        }
        list.add(Integer.valueOf(i11));
    }

    private l2.r h(int i11, androidx.media3.common.r rVar, List list, p0 p0Var) {
        if (i11 == 0) {
            return new s3.b();
        }
        if (i11 == 1) {
            return new s3.e();
        }
        if (i11 == 2) {
            return new s3.h();
        }
        if (i11 == 7) {
            return new e3.f(0, 0L);
        }
        if (i11 == 8) {
            return i(this.f11785b, this.f11786c, p0Var, rVar, list, this.f11787d);
        }
        if (i11 == 11) {
            return j(this.f11784a, this.f11788e, rVar, list, p0Var, this.f11785b, this.f11786c);
        }
        if (i11 != 13) {
            return null;
        }
        return new u(rVar.f10232d, p0Var, this.f11785b, this.f11786c);
    }

    private static f3.h i(s.a aVar, boolean z10, p0 p0Var, androidx.media3.common.r rVar, List list, int i11) {
        int i12 = m(rVar) ? 4 : 0;
        if (!z10) {
            aVar = s.a.f65046a;
            i12 |= 32;
        }
        s.a aVar2 = aVar;
        int j11 = i12 | f3.h.j(i11);
        if (list == null) {
            list = ImmutableList.of();
        }
        return new f3.h(aVar2, j11, p0Var, null, list, null);
    }

    private static k0 j(int i11, boolean z10, androidx.media3.common.r rVar, List list, p0 p0Var, s.a aVar, boolean z11) {
        int i12;
        int i13 = i11 | 16;
        if (list != null) {
            i13 = i11 | 48;
        } else {
            list = z10 ? Collections.singletonList(new r.b().u0(MimeTypes.APPLICATION_CEA608).N()) : Collections.emptyList();
        }
        String str = rVar.f10239k;
        if (!TextUtils.isEmpty(str)) {
            if (!y.b(str, MimeTypes.AUDIO_AAC)) {
                i13 |= 2;
            }
            if (!y.b(str, MimeTypes.VIDEO_H264)) {
                i13 |= 4;
            }
        }
        if (z11) {
            i12 = 0;
        } else {
            aVar = s.a.f65046a;
            i12 = 1;
        }
        return new k0(2, i12, aVar, p0Var, new s3.j(i13, list), 112800);
    }

    private static boolean m(androidx.media3.common.r rVar) {
        x xVar = rVar.f10240l;
        if (xVar == null) {
            return false;
        }
        for (int i11 = 0; i11 < xVar.e(); i11++) {
            if (xVar.d(i11) instanceof s) {
                return !((s) r2).f12072c.isEmpty();
            }
        }
        return false;
    }

    private static boolean o(l2.r rVar, l2.s sVar) {
        try {
            boolean d11 = rVar.d(sVar);
            sVar.resetPeekPosition();
            return d11;
        } catch (EOFException unused) {
            sVar.resetPeekPosition();
            return false;
        } catch (Throwable th2) {
            sVar.resetPeekPosition();
            throw th2;
        }
    }

    @Override // androidx.media3.exoplayer.hls.g
    public androidx.media3.common.r d(androidx.media3.common.r rVar) {
        String str;
        if (!this.f11786c || !this.f11785b.a(rVar)) {
            return rVar;
        }
        r.b W = rVar.b().u0("application/x-media3-cues").W(this.f11785b.b(rVar));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(rVar.f10243o);
        if (rVar.f10239k != null) {
            str = " " + rVar.f10239k;
        } else {
            str = "";
        }
        sb2.append(str);
        return W.S(sb2.toString()).y0(Long.MAX_VALUE).N();
    }

    @Override // androidx.media3.exoplayer.hls.g
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public b e(Uri uri, androidx.media3.common.r rVar, List list, p0 p0Var, Map map, l2.s sVar, f4 f4Var) {
        int a11 = androidx.media3.common.o.a(rVar.f10243o);
        int b11 = androidx.media3.common.o.b(map);
        int c11 = androidx.media3.common.o.c(uri);
        int[] iArr = f11783f;
        ArrayList arrayList = new ArrayList(iArr.length);
        f(a11, arrayList);
        f(b11, arrayList);
        f(c11, arrayList);
        for (int i11 : iArr) {
            f(i11, arrayList);
        }
        sVar.resetPeekPosition();
        l2.r rVar2 = null;
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            int intValue = ((Integer) arrayList.get(i12)).intValue();
            l2.r rVar3 = (l2.r) androidx.media3.common.util.a.e(h(intValue, rVar, list, p0Var));
            if (o(rVar3, sVar)) {
                return new b(rVar3, rVar, p0Var, this.f11785b, this.f11786c);
            }
            if (rVar2 == null && (intValue == a11 || intValue == b11 || intValue == c11 || intValue == 11)) {
                rVar2 = rVar3;
            }
        }
        return new b((l2.r) androidx.media3.common.util.a.e(rVar2), rVar, p0Var, this.f11785b, this.f11786c);
    }

    @Override // androidx.media3.exoplayer.hls.g
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public d c(boolean z10) {
        this.f11786c = z10;
        return this;
    }

    @Override // androidx.media3.exoplayer.hls.g
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public d b(int i11) {
        this.f11787d = i11;
        return this;
    }

    @Override // androidx.media3.exoplayer.hls.g
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public d a(s.a aVar) {
        this.f11785b = aVar;
        return this;
    }
}
