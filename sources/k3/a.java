package k3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.core.view.ViewCompat;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.i0;
import androidx.media3.common.util.j0;
import androidx.media3.common.util.m;
import androidx.media3.common.util.u;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import i3.k;
import i3.r;
import i3.s;
import java.util.ArrayList;
import java.util.List;
import u1.a;

/* loaded from: classes2.dex */
public final class a implements s {

    /* renamed from: h, reason: collision with root package name */
    private static final byte[] f66701h = {0, 7, 8, 15};

    /* renamed from: i, reason: collision with root package name */
    private static final byte[] f66702i = {0, 119, -120, -1};

    /* renamed from: j, reason: collision with root package name */
    private static final byte[] f66703j = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* renamed from: a, reason: collision with root package name */
    private final Paint f66704a;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f66705b;

    /* renamed from: c, reason: collision with root package name */
    private final Canvas f66706c;

    /* renamed from: d, reason: collision with root package name */
    private final b f66707d;

    /* renamed from: e, reason: collision with root package name */
    private final C0834a f66708e;

    /* renamed from: f, reason: collision with root package name */
    private final h f66709f;

    /* renamed from: g, reason: collision with root package name */
    private Bitmap f66710g;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k3.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0834a {

        /* renamed from: a, reason: collision with root package name */
        public final int f66711a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f66712b;

        /* renamed from: c, reason: collision with root package name */
        public final int[] f66713c;

        /* renamed from: d, reason: collision with root package name */
        public final int[] f66714d;

        public C0834a(int i11, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f66711a = i11;
            this.f66712b = iArr;
            this.f66713c = iArr2;
            this.f66714d = iArr3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f66715a;

        /* renamed from: b, reason: collision with root package name */
        public final int f66716b;

        /* renamed from: c, reason: collision with root package name */
        public final int f66717c;

        /* renamed from: d, reason: collision with root package name */
        public final int f66718d;

        /* renamed from: e, reason: collision with root package name */
        public final int f66719e;

        /* renamed from: f, reason: collision with root package name */
        public final int f66720f;

        public b(int i11, int i12, int i13, int i14, int i15, int i16) {
            this.f66715a = i11;
            this.f66716b = i12;
            this.f66717c = i13;
            this.f66718d = i14;
            this.f66719e = i15;
            this.f66720f = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f66721a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f66722b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f66723c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f66724d;

        public c(int i11, boolean z10, byte[] bArr, byte[] bArr2) {
            this.f66721a = i11;
            this.f66722b = z10;
            this.f66723c = bArr;
            this.f66724d = bArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f66725a;

        /* renamed from: b, reason: collision with root package name */
        public final int f66726b;

        /* renamed from: c, reason: collision with root package name */
        public final int f66727c;

        /* renamed from: d, reason: collision with root package name */
        public final SparseArray f66728d;

        public d(int i11, int i12, int i13, SparseArray sparseArray) {
            this.f66725a = i11;
            this.f66726b = i12;
            this.f66727c = i13;
            this.f66728d = sparseArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final int f66729a;

        /* renamed from: b, reason: collision with root package name */
        public final int f66730b;

        public e(int i11, int i12) {
            this.f66729a = i11;
            this.f66730b = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public final int f66731a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f66732b;

        /* renamed from: c, reason: collision with root package name */
        public final int f66733c;

        /* renamed from: d, reason: collision with root package name */
        public final int f66734d;

        /* renamed from: e, reason: collision with root package name */
        public final int f66735e;

        /* renamed from: f, reason: collision with root package name */
        public final int f66736f;

        /* renamed from: g, reason: collision with root package name */
        public final int f66737g;

        /* renamed from: h, reason: collision with root package name */
        public final int f66738h;

        /* renamed from: i, reason: collision with root package name */
        public final int f66739i;

        /* renamed from: j, reason: collision with root package name */
        public final int f66740j;

        /* renamed from: k, reason: collision with root package name */
        public final SparseArray f66741k;

        public f(int i11, boolean z10, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, SparseArray sparseArray) {
            this.f66731a = i11;
            this.f66732b = z10;
            this.f66733c = i12;
            this.f66734d = i13;
            this.f66735e = i14;
            this.f66736f = i15;
            this.f66737g = i16;
            this.f66738h = i17;
            this.f66739i = i18;
            this.f66740j = i19;
            this.f66741k = sparseArray;
        }

        public void a(f fVar) {
            SparseArray sparseArray = fVar.f66741k;
            for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                this.f66741k.put(sparseArray.keyAt(i11), (g) sparseArray.valueAt(i11));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public final int f66742a;

        /* renamed from: b, reason: collision with root package name */
        public final int f66743b;

        /* renamed from: c, reason: collision with root package name */
        public final int f66744c;

        /* renamed from: d, reason: collision with root package name */
        public final int f66745d;

        /* renamed from: e, reason: collision with root package name */
        public final int f66746e;

        /* renamed from: f, reason: collision with root package name */
        public final int f66747f;

        public g(int i11, int i12, int i13, int i14, int i15, int i16) {
            this.f66742a = i11;
            this.f66743b = i12;
            this.f66744c = i13;
            this.f66745d = i14;
            this.f66746e = i15;
            this.f66747f = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class h {

        /* renamed from: a, reason: collision with root package name */
        public final int f66748a;

        /* renamed from: b, reason: collision with root package name */
        public final int f66749b;

        /* renamed from: c, reason: collision with root package name */
        public final SparseArray f66750c = new SparseArray();

        /* renamed from: d, reason: collision with root package name */
        public final SparseArray f66751d = new SparseArray();

        /* renamed from: e, reason: collision with root package name */
        public final SparseArray f66752e = new SparseArray();

        /* renamed from: f, reason: collision with root package name */
        public final SparseArray f66753f = new SparseArray();

        /* renamed from: g, reason: collision with root package name */
        public final SparseArray f66754g = new SparseArray();

        /* renamed from: h, reason: collision with root package name */
        public b f66755h;

        /* renamed from: i, reason: collision with root package name */
        public d f66756i;

        public h(int i11, int i12) {
            this.f66748a = i11;
            this.f66749b = i12;
        }

        public void a() {
            this.f66750c.clear();
            this.f66751d.clear();
            this.f66752e.clear();
            this.f66753f.clear();
            this.f66754g.clear();
            this.f66755h = null;
            this.f66756i = null;
        }
    }

    public a(List list) {
        j0 j0Var = new j0((byte[]) list.get(0));
        int P = j0Var.P();
        int P2 = j0Var.P();
        Paint paint = new Paint();
        this.f66704a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f66705b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f66706c = new Canvas();
        this.f66707d = new b(719, 575, 0, 719, 0, 575);
        this.f66708e = new C0834a(0, e(), f(), g());
        this.f66709f = new h(P, P2);
    }

    private static byte[] d(int i11, int i12, i0 i0Var) {
        byte[] bArr = new byte[i11];
        for (int i13 = 0; i13 < i11; i13++) {
            bArr[i13] = (byte) i0Var.h(i12);
        }
        return bArr;
    }

    private static int[] e() {
        return new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    private static int[] f() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i11 = 1; i11 < 16; i11++) {
            if (i11 < 8) {
                iArr[i11] = h(255, (i11 & 1) != 0 ? 255 : 0, (i11 & 2) != 0 ? 255 : 0, (i11 & 4) != 0 ? 255 : 0);
            } else {
                iArr[i11] = h(255, (i11 & 1) != 0 ? 127 : 0, (i11 & 2) != 0 ? 127 : 0, (i11 & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    private static int[] g() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i11 = 0; i11 < 256; i11++) {
            if (i11 < 8) {
                iArr[i11] = h(63, (i11 & 1) != 0 ? 255 : 0, (i11 & 2) != 0 ? 255 : 0, (i11 & 4) == 0 ? 0 : 255);
            } else {
                int i12 = i11 & Sdk$SDKError.Reason.PRIVACY_URL_ERROR_VALUE;
                if (i12 == 0) {
                    iArr[i11] = h(255, ((i11 & 1) != 0 ? 85 : 0) + ((i11 & 16) != 0 ? 170 : 0), ((i11 & 2) != 0 ? 85 : 0) + ((i11 & 32) != 0 ? 170 : 0), ((i11 & 4) == 0 ? 0 : 85) + ((i11 & 64) == 0 ? 0 : 170));
                } else if (i12 == 8) {
                    iArr[i11] = h(127, ((i11 & 1) != 0 ? 85 : 0) + ((i11 & 16) != 0 ? 170 : 0), ((i11 & 2) != 0 ? 85 : 0) + ((i11 & 32) != 0 ? 170 : 0), ((i11 & 4) == 0 ? 0 : 85) + ((i11 & 64) == 0 ? 0 : 170));
                } else if (i12 == 128) {
                    iArr[i11] = h(255, ((i11 & 1) != 0 ? 43 : 0) + 127 + ((i11 & 16) != 0 ? 85 : 0), ((i11 & 2) != 0 ? 43 : 0) + 127 + ((i11 & 32) != 0 ? 85 : 0), ((i11 & 4) == 0 ? 0 : 43) + 127 + ((i11 & 64) == 0 ? 0 : 85));
                } else if (i12 == 136) {
                    iArr[i11] = h(255, ((i11 & 1) != 0 ? 43 : 0) + ((i11 & 16) != 0 ? 85 : 0), ((i11 & 2) != 0 ? 43 : 0) + ((i11 & 32) != 0 ? 85 : 0), ((i11 & 4) == 0 ? 0 : 43) + ((i11 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    private static int h(int i11, int i12, int i13, int i14) {
        return (i11 << 24) | (i12 << 16) | (i13 << 8) | i14;
    }

    private static int i(i0 i0Var, int[] iArr, byte[] bArr, int i11, int i12, Paint paint, Canvas canvas) {
        boolean z10;
        int i13;
        int h11;
        int h12;
        int i14 = i11;
        boolean z11 = false;
        while (true) {
            int h13 = i0Var.h(2);
            if (h13 != 0) {
                z10 = z11;
                i13 = 1;
            } else {
                if (i0Var.g()) {
                    h11 = i0Var.h(3) + 3;
                    h12 = i0Var.h(2);
                } else {
                    if (i0Var.g()) {
                        z10 = z11;
                        i13 = 1;
                    } else {
                        int h14 = i0Var.h(2);
                        if (h14 == 0) {
                            z10 = true;
                        } else if (h14 == 1) {
                            z10 = z11;
                            i13 = 2;
                        } else if (h14 == 2) {
                            h11 = i0Var.h(4) + 12;
                            h12 = i0Var.h(2);
                        } else if (h14 != 3) {
                            z10 = z11;
                        } else {
                            h11 = i0Var.h(8) + 29;
                            h12 = i0Var.h(2);
                        }
                        h13 = 0;
                        i13 = 0;
                    }
                    h13 = 0;
                }
                z10 = z11;
                i13 = h11;
                h13 = h12;
            }
            if (i13 != 0 && paint != null) {
                if (bArr != null) {
                    h13 = bArr[h13];
                }
                paint.setColor(iArr[h13]);
                canvas.drawRect(i14, i12, i14 + i13, i12 + 1, paint);
            }
            i14 += i13;
            if (z10) {
                return i14;
            }
            z11 = z10;
        }
    }

    private static int j(i0 i0Var, int[] iArr, byte[] bArr, int i11, int i12, Paint paint, Canvas canvas) {
        boolean z10;
        int i13;
        int h11;
        int h12;
        int i14 = i11;
        boolean z11 = false;
        while (true) {
            int h13 = i0Var.h(4);
            if (h13 != 0) {
                z10 = z11;
                i13 = 1;
            } else if (i0Var.g()) {
                if (i0Var.g()) {
                    int h14 = i0Var.h(2);
                    if (h14 == 0) {
                        z10 = z11;
                        i13 = 1;
                    } else if (h14 == 1) {
                        z10 = z11;
                        i13 = 2;
                    } else if (h14 == 2) {
                        h11 = i0Var.h(4) + 9;
                        h12 = i0Var.h(4);
                    } else if (h14 != 3) {
                        z10 = z11;
                        h13 = 0;
                        i13 = 0;
                    } else {
                        h11 = i0Var.h(8) + 25;
                        h12 = i0Var.h(4);
                    }
                    h13 = 0;
                } else {
                    h11 = i0Var.h(2) + 4;
                    h12 = i0Var.h(4);
                }
                z10 = z11;
                i13 = h11;
                h13 = h12;
            } else {
                int h15 = i0Var.h(3);
                if (h15 != 0) {
                    z10 = z11;
                    i13 = h15 + 2;
                    h13 = 0;
                } else {
                    z10 = true;
                    h13 = 0;
                    i13 = 0;
                }
            }
            if (i13 != 0 && paint != null) {
                if (bArr != null) {
                    h13 = bArr[h13];
                }
                paint.setColor(iArr[h13]);
                canvas.drawRect(i14, i12, i14 + i13, i12 + 1, paint);
            }
            i14 += i13;
            if (z10) {
                return i14;
            }
            z11 = z10;
        }
    }

    private static int k(i0 i0Var, int[] iArr, byte[] bArr, int i11, int i12, Paint paint, Canvas canvas) {
        boolean z10;
        int h11;
        int i13 = i11;
        boolean z11 = false;
        while (true) {
            int h12 = i0Var.h(8);
            if (h12 != 0) {
                z10 = z11;
                h11 = 1;
            } else if (i0Var.g()) {
                z10 = z11;
                h11 = i0Var.h(7);
                h12 = i0Var.h(8);
            } else {
                int h13 = i0Var.h(7);
                if (h13 != 0) {
                    z10 = z11;
                    h11 = h13;
                    h12 = 0;
                } else {
                    z10 = true;
                    h12 = 0;
                    h11 = 0;
                }
            }
            if (h11 != 0 && paint != null) {
                if (bArr != null) {
                    h12 = bArr[h12];
                }
                paint.setColor(iArr[h12]);
                canvas.drawRect(i13, i12, i13 + h11, i12 + 1, paint);
            }
            i13 += h11;
            if (z10) {
                return i13;
            }
            z11 = z10;
        }
    }

    private static void l(byte[] bArr, int[] iArr, int i11, int i12, int i13, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        i0 i0Var = new i0(bArr);
        int i14 = i12;
        int i15 = i13;
        byte[] bArr5 = null;
        byte[] bArr6 = null;
        byte[] bArr7 = null;
        while (i0Var.b() != 0) {
            int h11 = i0Var.h(8);
            if (h11 != 240) {
                switch (h11) {
                    case 16:
                        if (i11 != 3) {
                            if (i11 != 2) {
                                bArr2 = null;
                                i14 = i(i0Var, iArr, bArr2, i14, i15, paint, canvas);
                                i0Var.c();
                                break;
                            } else {
                                bArr3 = bArr7 == null ? f66701h : bArr7;
                            }
                        } else {
                            bArr3 = bArr5 == null ? f66702i : bArr5;
                        }
                        bArr2 = bArr3;
                        i14 = i(i0Var, iArr, bArr2, i14, i15, paint, canvas);
                        i0Var.c();
                    case 17:
                        if (i11 == 3) {
                            bArr4 = bArr6 == null ? f66703j : bArr6;
                        } else {
                            bArr4 = null;
                        }
                        i14 = j(i0Var, iArr, bArr4, i14, i15, paint, canvas);
                        i0Var.c();
                        break;
                    case 18:
                        i14 = k(i0Var, iArr, null, i14, i15, paint, canvas);
                        break;
                    default:
                        switch (h11) {
                            case 32:
                                bArr7 = d(4, 4, i0Var);
                                break;
                            case 33:
                                bArr5 = d(4, 8, i0Var);
                                break;
                            case 34:
                                bArr6 = d(16, 8, i0Var);
                                break;
                        }
                }
            } else {
                i15 += 2;
                i14 = i12;
            }
        }
    }

    private static void m(c cVar, C0834a c0834a, int i11, int i12, int i13, Paint paint, Canvas canvas) {
        int[] iArr = i11 == 3 ? c0834a.f66714d : i11 == 2 ? c0834a.f66713c : c0834a.f66712b;
        l(cVar.f66723c, iArr, i11, i12, i13, paint, canvas);
        l(cVar.f66724d, iArr, i11, i12, i13 + 1, paint, canvas);
    }

    private i3.e n(i0 i0Var) {
        int i11;
        SparseArray sparseArray;
        while (i0Var.b() >= 48 && i0Var.h(8) == 15) {
            t(i0Var, this.f66709f);
        }
        h hVar = this.f66709f;
        d dVar = hVar.f66756i;
        if (dVar == null) {
            return new i3.e(ImmutableList.of(), C.TIME_UNSET, C.TIME_UNSET);
        }
        b bVar = hVar.f66755h;
        if (bVar == null) {
            bVar = this.f66707d;
        }
        Bitmap bitmap = this.f66710g;
        if (bitmap == null || bVar.f66715a + 1 != bitmap.getWidth() || bVar.f66716b + 1 != this.f66710g.getHeight()) {
            Bitmap createBitmap = Bitmap.createBitmap(bVar.f66715a + 1, bVar.f66716b + 1, Bitmap.Config.ARGB_8888);
            this.f66710g = createBitmap;
            this.f66706c.setBitmap(createBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray sparseArray2 = dVar.f66728d;
        for (int i12 = 0; i12 < sparseArray2.size(); i12++) {
            this.f66706c.save();
            e eVar = (e) sparseArray2.valueAt(i12);
            f fVar = (f) this.f66709f.f66750c.get(sparseArray2.keyAt(i12));
            int i13 = eVar.f66729a + bVar.f66717c;
            int i14 = eVar.f66730b + bVar.f66719e;
            this.f66706c.clipRect(i13, i14, Math.min(fVar.f66733c + i13, bVar.f66718d), Math.min(fVar.f66734d + i14, bVar.f66720f));
            C0834a c0834a = (C0834a) this.f66709f.f66751d.get(fVar.f66737g);
            if (c0834a == null && (c0834a = (C0834a) this.f66709f.f66753f.get(fVar.f66737g)) == null) {
                c0834a = this.f66708e;
            }
            SparseArray sparseArray3 = fVar.f66741k;
            int i15 = 0;
            while (i15 < sparseArray3.size()) {
                int keyAt = sparseArray3.keyAt(i15);
                g gVar = (g) sparseArray3.valueAt(i15);
                c cVar = (c) this.f66709f.f66752e.get(keyAt);
                c cVar2 = cVar == null ? (c) this.f66709f.f66754g.get(keyAt) : cVar;
                if (cVar2 != null) {
                    i11 = i15;
                    sparseArray = sparseArray3;
                    m(cVar2, c0834a, fVar.f66736f, gVar.f66744c + i13, i14 + gVar.f66745d, cVar2.f66722b ? null : this.f66704a, this.f66706c);
                } else {
                    i11 = i15;
                    sparseArray = sparseArray3;
                }
                i15 = i11 + 1;
                sparseArray3 = sparseArray;
            }
            if (fVar.f66732b) {
                int i16 = fVar.f66736f;
                this.f66705b.setColor(i16 == 3 ? c0834a.f66714d[fVar.f66738h] : i16 == 2 ? c0834a.f66713c[fVar.f66739i] : c0834a.f66712b[fVar.f66740j]);
                this.f66706c.drawRect(i13, i14, fVar.f66733c + i13, fVar.f66734d + i14, this.f66705b);
            }
            arrayList.add(new a.b().f(Bitmap.createBitmap(this.f66710g, i13, i14, fVar.f66733c, fVar.f66734d)).k(i13 / bVar.f66715a).l(0).h(i14 / bVar.f66716b, 0).i(0).n(fVar.f66733c / bVar.f66715a).g(fVar.f66734d / bVar.f66716b).a());
            this.f66706c.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f66706c.restore();
        }
        return new i3.e(arrayList, C.TIME_UNSET, C.TIME_UNSET);
    }

    private static C0834a o(i0 i0Var, int i11) {
        int h11;
        int i12;
        int h12;
        int i13;
        int i14;
        int i15 = 8;
        int h13 = i0Var.h(8);
        i0Var.r(8);
        int i16 = 2;
        int i17 = i11 - 2;
        int[] e11 = e();
        int[] f11 = f();
        int[] g11 = g();
        while (i17 > 0) {
            int h14 = i0Var.h(i15);
            int h15 = i0Var.h(i15);
            int[] iArr = (h15 & 128) != 0 ? e11 : (h15 & 64) != 0 ? f11 : g11;
            if ((h15 & 1) != 0) {
                i13 = i0Var.h(i15);
                i14 = i0Var.h(i15);
                h11 = i0Var.h(i15);
                h12 = i0Var.h(i15);
                i12 = i17 - 6;
            } else {
                int h16 = i0Var.h(6) << i16;
                int h17 = i0Var.h(4) << 4;
                h11 = i0Var.h(4) << 4;
                i12 = i17 - 4;
                h12 = i0Var.h(i16) << 6;
                i13 = h16;
                i14 = h17;
            }
            if (i13 == 0) {
                h12 = 255;
                i14 = 0;
                h11 = 0;
            }
            double d11 = i13;
            double d12 = i14 - 128;
            double d13 = h11 - 128;
            iArr[h14] = h((byte) (255 - (h12 & 255)), a1.p((int) (d11 + (1.402d * d12)), 0, 255), a1.p((int) ((d11 - (0.34414d * d13)) - (d12 * 0.71414d)), 0, 255), a1.p((int) (d11 + (d13 * 1.772d)), 0, 255));
            i17 = i12;
            h13 = h13;
            i15 = 8;
            i16 = 2;
        }
        return new C0834a(h13, e11, f11, g11);
    }

    private static b p(i0 i0Var) {
        int i11;
        int i12;
        int i13;
        int i14;
        i0Var.r(4);
        boolean g11 = i0Var.g();
        i0Var.r(3);
        int h11 = i0Var.h(16);
        int h12 = i0Var.h(16);
        if (g11) {
            int h13 = i0Var.h(16);
            int h14 = i0Var.h(16);
            int h15 = i0Var.h(16);
            i14 = i0Var.h(16);
            i13 = h14;
            i12 = h15;
            i11 = h13;
        } else {
            i11 = 0;
            i12 = 0;
            i13 = h11;
            i14 = h12;
        }
        return new b(h11, h12, i11, i13, i12, i14);
    }

    private static c q(i0 i0Var) {
        byte[] bArr;
        int h11 = i0Var.h(16);
        i0Var.r(4);
        int h12 = i0Var.h(2);
        boolean g11 = i0Var.g();
        i0Var.r(1);
        byte[] bArr2 = a1.f10437f;
        if (h12 == 1) {
            i0Var.r(i0Var.h(8) * 16);
        } else if (h12 == 0) {
            int h13 = i0Var.h(16);
            int h14 = i0Var.h(16);
            if (h13 > 0) {
                bArr2 = new byte[h13];
                i0Var.k(bArr2, 0, h13);
            }
            if (h14 > 0) {
                bArr = new byte[h14];
                i0Var.k(bArr, 0, h14);
                return new c(h11, g11, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new c(h11, g11, bArr2, bArr);
    }

    private static d r(i0 i0Var, int i11) {
        int h11 = i0Var.h(8);
        int h12 = i0Var.h(4);
        int h13 = i0Var.h(2);
        i0Var.r(2);
        int i12 = i11 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i12 > 0) {
            int h14 = i0Var.h(8);
            i0Var.r(8);
            i12 -= 6;
            sparseArray.put(h14, new e(i0Var.h(16), i0Var.h(16)));
        }
        return new d(h11, h12, h13, sparseArray);
    }

    private static f s(i0 i0Var, int i11) {
        int i12;
        int i13;
        int i14;
        int h11 = i0Var.h(8);
        i0Var.r(4);
        boolean g11 = i0Var.g();
        i0Var.r(3);
        int i15 = 16;
        int h12 = i0Var.h(16);
        int h13 = i0Var.h(16);
        int h14 = i0Var.h(3);
        int h15 = i0Var.h(3);
        int i16 = 2;
        i0Var.r(2);
        int h16 = i0Var.h(8);
        int h17 = i0Var.h(8);
        int h18 = i0Var.h(4);
        int h19 = i0Var.h(2);
        i0Var.r(2);
        int i17 = i11 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i17 > 0) {
            int h20 = i0Var.h(i15);
            int h21 = i0Var.h(i16);
            int h22 = i0Var.h(i16);
            int h23 = i0Var.h(12);
            int i18 = h19;
            i0Var.r(4);
            int h24 = i0Var.h(12);
            int i19 = i17 - 6;
            if (h21 != 1) {
                i12 = 2;
                if (h21 != 2) {
                    i14 = 0;
                    i13 = 0;
                    i17 = i19;
                    sparseArray.put(h20, new g(h21, h22, h23, h24, i14, i13));
                    i16 = i12;
                    h19 = i18;
                    i15 = 16;
                }
            } else {
                i12 = 2;
            }
            i17 -= 8;
            i14 = i0Var.h(8);
            i13 = i0Var.h(8);
            sparseArray.put(h20, new g(h21, h22, h23, h24, i14, i13));
            i16 = i12;
            h19 = i18;
            i15 = 16;
        }
        return new f(h11, g11, h12, h13, h14, h15, h16, h17, h18, h19, sparseArray);
    }

    private static void t(i0 i0Var, h hVar) {
        f fVar;
        int h11 = i0Var.h(8);
        int h12 = i0Var.h(16);
        int h13 = i0Var.h(16);
        int d11 = i0Var.d() + h13;
        if (h13 * 8 > i0Var.b()) {
            u.h("DvbParser", "Data field length exceeds limit");
            i0Var.r(i0Var.b());
            return;
        }
        switch (h11) {
            case 16:
                if (h12 == hVar.f66748a) {
                    d dVar = hVar.f66756i;
                    d r11 = r(i0Var, h13);
                    if (r11.f66727c == 0) {
                        if (dVar != null && dVar.f66726b != r11.f66726b) {
                            hVar.f66756i = r11;
                            break;
                        }
                    } else {
                        hVar.f66756i = r11;
                        hVar.f66750c.clear();
                        hVar.f66751d.clear();
                        hVar.f66752e.clear();
                        break;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.f66756i;
                if (h12 == hVar.f66748a && dVar2 != null) {
                    f s11 = s(i0Var, h13);
                    if (dVar2.f66727c == 0 && (fVar = (f) hVar.f66750c.get(s11.f66731a)) != null) {
                        s11.a(fVar);
                    }
                    hVar.f66750c.put(s11.f66731a, s11);
                    break;
                }
                break;
            case 18:
                if (h12 != hVar.f66748a) {
                    if (h12 == hVar.f66749b) {
                        C0834a o11 = o(i0Var, h13);
                        hVar.f66753f.put(o11.f66711a, o11);
                        break;
                    }
                } else {
                    C0834a o12 = o(i0Var, h13);
                    hVar.f66751d.put(o12.f66711a, o12);
                    break;
                }
                break;
            case 19:
                if (h12 != hVar.f66748a) {
                    if (h12 == hVar.f66749b) {
                        c q11 = q(i0Var);
                        hVar.f66754g.put(q11.f66721a, q11);
                        break;
                    }
                } else {
                    c q12 = q(i0Var);
                    hVar.f66752e.put(q12.f66721a, q12);
                    break;
                }
                break;
            case 20:
                if (h12 == hVar.f66748a) {
                    hVar.f66755h = p(i0Var);
                    break;
                }
                break;
        }
        i0Var.s(d11 - i0Var.d());
    }

    @Override // i3.s
    public void a(byte[] bArr, int i11, int i12, s.b bVar, m mVar) {
        i0 i0Var = new i0(bArr, i12 + i11);
        i0Var.p(i11);
        mVar.accept(n(i0Var));
    }

    @Override // i3.s
    public /* synthetic */ k b(byte[] bArr, int i11, int i12) {
        return r.a(this, bArr, i11, i12);
    }

    @Override // i3.s
    public int c() {
        return 2;
    }

    @Override // i3.s
    public void reset() {
        this.f66709f.a();
    }
}
