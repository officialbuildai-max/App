package da;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.core.view.ViewCompat;
import ba.b;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
final class b {

    /* renamed from: h, reason: collision with root package name */
    private static final byte[] f61371h = {0, 7, 8, 15};

    /* renamed from: i, reason: collision with root package name */
    private static final byte[] f61372i = {0, 119, -120, -1};

    /* renamed from: j, reason: collision with root package name */
    private static final byte[] f61373j = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* renamed from: a, reason: collision with root package name */
    private final Paint f61374a;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f61375b;

    /* renamed from: c, reason: collision with root package name */
    private final Canvas f61376c;

    /* renamed from: d, reason: collision with root package name */
    private final C0756b f61377d;

    /* renamed from: e, reason: collision with root package name */
    private final a f61378e;

    /* renamed from: f, reason: collision with root package name */
    private final h f61379f;

    /* renamed from: g, reason: collision with root package name */
    private Bitmap f61380g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f61381a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f61382b;

        /* renamed from: c, reason: collision with root package name */
        public final int[] f61383c;

        /* renamed from: d, reason: collision with root package name */
        public final int[] f61384d;

        public a(int i11, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f61381a = i11;
            this.f61382b = iArr;
            this.f61383c = iArr2;
            this.f61384d = iArr3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: da.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0756b {

        /* renamed from: a, reason: collision with root package name */
        public final int f61385a;

        /* renamed from: b, reason: collision with root package name */
        public final int f61386b;

        /* renamed from: c, reason: collision with root package name */
        public final int f61387c;

        /* renamed from: d, reason: collision with root package name */
        public final int f61388d;

        /* renamed from: e, reason: collision with root package name */
        public final int f61389e;

        /* renamed from: f, reason: collision with root package name */
        public final int f61390f;

        public C0756b(int i11, int i12, int i13, int i14, int i15, int i16) {
            this.f61385a = i11;
            this.f61386b = i12;
            this.f61387c = i13;
            this.f61388d = i14;
            this.f61389e = i15;
            this.f61390f = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f61391a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f61392b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f61393c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f61394d;

        public c(int i11, boolean z10, byte[] bArr, byte[] bArr2) {
            this.f61391a = i11;
            this.f61392b = z10;
            this.f61393c = bArr;
            this.f61394d = bArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f61395a;

        /* renamed from: b, reason: collision with root package name */
        public final int f61396b;

        /* renamed from: c, reason: collision with root package name */
        public final int f61397c;

        /* renamed from: d, reason: collision with root package name */
        public final SparseArray f61398d;

        public d(int i11, int i12, int i13, SparseArray sparseArray) {
            this.f61395a = i11;
            this.f61396b = i12;
            this.f61397c = i13;
            this.f61398d = sparseArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final int f61399a;

        /* renamed from: b, reason: collision with root package name */
        public final int f61400b;

        public e(int i11, int i12) {
            this.f61399a = i11;
            this.f61400b = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public final int f61401a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f61402b;

        /* renamed from: c, reason: collision with root package name */
        public final int f61403c;

        /* renamed from: d, reason: collision with root package name */
        public final int f61404d;

        /* renamed from: e, reason: collision with root package name */
        public final int f61405e;

        /* renamed from: f, reason: collision with root package name */
        public final int f61406f;

        /* renamed from: g, reason: collision with root package name */
        public final int f61407g;

        /* renamed from: h, reason: collision with root package name */
        public final int f61408h;

        /* renamed from: i, reason: collision with root package name */
        public final int f61409i;

        /* renamed from: j, reason: collision with root package name */
        public final int f61410j;

        /* renamed from: k, reason: collision with root package name */
        public final SparseArray f61411k;

        public f(int i11, boolean z10, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, SparseArray sparseArray) {
            this.f61401a = i11;
            this.f61402b = z10;
            this.f61403c = i12;
            this.f61404d = i13;
            this.f61405e = i14;
            this.f61406f = i15;
            this.f61407g = i16;
            this.f61408h = i17;
            this.f61409i = i18;
            this.f61410j = i19;
            this.f61411k = sparseArray;
        }

        public void a(f fVar) {
            SparseArray sparseArray = fVar.f61411k;
            for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                this.f61411k.put(sparseArray.keyAt(i11), (g) sparseArray.valueAt(i11));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public final int f61412a;

        /* renamed from: b, reason: collision with root package name */
        public final int f61413b;

        /* renamed from: c, reason: collision with root package name */
        public final int f61414c;

        /* renamed from: d, reason: collision with root package name */
        public final int f61415d;

        /* renamed from: e, reason: collision with root package name */
        public final int f61416e;

        /* renamed from: f, reason: collision with root package name */
        public final int f61417f;

        public g(int i11, int i12, int i13, int i14, int i15, int i16) {
            this.f61412a = i11;
            this.f61413b = i12;
            this.f61414c = i13;
            this.f61415d = i14;
            this.f61416e = i15;
            this.f61417f = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class h {

        /* renamed from: a, reason: collision with root package name */
        public final int f61418a;

        /* renamed from: b, reason: collision with root package name */
        public final int f61419b;

        /* renamed from: c, reason: collision with root package name */
        public final SparseArray f61420c = new SparseArray();

        /* renamed from: d, reason: collision with root package name */
        public final SparseArray f61421d = new SparseArray();

        /* renamed from: e, reason: collision with root package name */
        public final SparseArray f61422e = new SparseArray();

        /* renamed from: f, reason: collision with root package name */
        public final SparseArray f61423f = new SparseArray();

        /* renamed from: g, reason: collision with root package name */
        public final SparseArray f61424g = new SparseArray();

        /* renamed from: h, reason: collision with root package name */
        public C0756b f61425h;

        /* renamed from: i, reason: collision with root package name */
        public d f61426i;

        public h(int i11, int i12) {
            this.f61418a = i11;
            this.f61419b = i12;
        }

        public void a() {
            this.f61420c.clear();
            this.f61421d.clear();
            this.f61422e.clear();
            this.f61423f.clear();
            this.f61424g.clear();
            this.f61425h = null;
            this.f61426i = null;
        }
    }

    public b(int i11, int i12) {
        Paint paint = new Paint();
        this.f61374a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f61375b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f61376c = new Canvas();
        this.f61377d = new C0756b(719, 575, 0, 719, 0, 575);
        this.f61378e = new a(0, c(), d(), e());
        this.f61379f = new h(i11, i12);
    }

    private static byte[] a(int i11, int i12, c0 c0Var) {
        byte[] bArr = new byte[i11];
        for (int i13 = 0; i13 < i11; i13++) {
            bArr[i13] = (byte) c0Var.h(i12);
        }
        return bArr;
    }

    private static int[] c() {
        return new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    private static int[] d() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i11 = 1; i11 < 16; i11++) {
            if (i11 < 8) {
                iArr[i11] = f(255, (i11 & 1) != 0 ? 255 : 0, (i11 & 2) != 0 ? 255 : 0, (i11 & 4) != 0 ? 255 : 0);
            } else {
                iArr[i11] = f(255, (i11 & 1) != 0 ? 127 : 0, (i11 & 2) != 0 ? 127 : 0, (i11 & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    private static int[] e() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i11 = 0; i11 < 256; i11++) {
            if (i11 < 8) {
                iArr[i11] = f(63, (i11 & 1) != 0 ? 255 : 0, (i11 & 2) != 0 ? 255 : 0, (i11 & 4) == 0 ? 0 : 255);
            } else {
                int i12 = i11 & Sdk$SDKError.Reason.PRIVACY_URL_ERROR_VALUE;
                if (i12 == 0) {
                    iArr[i11] = f(255, ((i11 & 1) != 0 ? 85 : 0) + ((i11 & 16) != 0 ? 170 : 0), ((i11 & 2) != 0 ? 85 : 0) + ((i11 & 32) != 0 ? 170 : 0), ((i11 & 4) == 0 ? 0 : 85) + ((i11 & 64) == 0 ? 0 : 170));
                } else if (i12 == 8) {
                    iArr[i11] = f(127, ((i11 & 1) != 0 ? 85 : 0) + ((i11 & 16) != 0 ? 170 : 0), ((i11 & 2) != 0 ? 85 : 0) + ((i11 & 32) != 0 ? 170 : 0), ((i11 & 4) == 0 ? 0 : 85) + ((i11 & 64) == 0 ? 0 : 170));
                } else if (i12 == 128) {
                    iArr[i11] = f(255, ((i11 & 1) != 0 ? 43 : 0) + 127 + ((i11 & 16) != 0 ? 85 : 0), ((i11 & 2) != 0 ? 43 : 0) + 127 + ((i11 & 32) != 0 ? 85 : 0), ((i11 & 4) == 0 ? 0 : 43) + 127 + ((i11 & 64) == 0 ? 0 : 85));
                } else if (i12 == 136) {
                    iArr[i11] = f(255, ((i11 & 1) != 0 ? 43 : 0) + ((i11 & 16) != 0 ? 85 : 0), ((i11 & 2) != 0 ? 43 : 0) + ((i11 & 32) != 0 ? 85 : 0), ((i11 & 4) == 0 ? 0 : 43) + ((i11 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    private static int f(int i11, int i12, int i13, int i14) {
        return (i11 << 24) | (i12 << 16) | (i13 << 8) | i14;
    }

    private static int g(c0 c0Var, int[] iArr, byte[] bArr, int i11, int i12, Paint paint, Canvas canvas) {
        boolean z10;
        int i13;
        int h11;
        int h12;
        int i14 = i11;
        boolean z11 = false;
        while (true) {
            int h13 = c0Var.h(2);
            if (h13 != 0) {
                z10 = z11;
                i13 = 1;
            } else {
                if (c0Var.g()) {
                    h11 = c0Var.h(3) + 3;
                    h12 = c0Var.h(2);
                } else {
                    if (c0Var.g()) {
                        z10 = z11;
                        i13 = 1;
                    } else {
                        int h14 = c0Var.h(2);
                        if (h14 == 0) {
                            z10 = true;
                        } else if (h14 == 1) {
                            z10 = z11;
                            i13 = 2;
                        } else if (h14 == 2) {
                            h11 = c0Var.h(4) + 12;
                            h12 = c0Var.h(2);
                        } else if (h14 != 3) {
                            z10 = z11;
                        } else {
                            h11 = c0Var.h(8) + 29;
                            h12 = c0Var.h(2);
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

    private static int h(c0 c0Var, int[] iArr, byte[] bArr, int i11, int i12, Paint paint, Canvas canvas) {
        boolean z10;
        int i13;
        int h11;
        int h12;
        int i14 = i11;
        boolean z11 = false;
        while (true) {
            int h13 = c0Var.h(4);
            if (h13 != 0) {
                z10 = z11;
                i13 = 1;
            } else if (c0Var.g()) {
                if (c0Var.g()) {
                    int h14 = c0Var.h(2);
                    if (h14 == 0) {
                        z10 = z11;
                        i13 = 1;
                    } else if (h14 == 1) {
                        z10 = z11;
                        i13 = 2;
                    } else if (h14 == 2) {
                        h11 = c0Var.h(4) + 9;
                        h12 = c0Var.h(4);
                    } else if (h14 != 3) {
                        z10 = z11;
                        h13 = 0;
                        i13 = 0;
                    } else {
                        h11 = c0Var.h(8) + 25;
                        h12 = c0Var.h(4);
                    }
                    h13 = 0;
                } else {
                    h11 = c0Var.h(2) + 4;
                    h12 = c0Var.h(4);
                }
                z10 = z11;
                i13 = h11;
                h13 = h12;
            } else {
                int h15 = c0Var.h(3);
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

    private static int i(c0 c0Var, int[] iArr, byte[] bArr, int i11, int i12, Paint paint, Canvas canvas) {
        boolean z10;
        int h11;
        int i13 = i11;
        boolean z11 = false;
        while (true) {
            int h12 = c0Var.h(8);
            if (h12 != 0) {
                z10 = z11;
                h11 = 1;
            } else if (c0Var.g()) {
                z10 = z11;
                h11 = c0Var.h(7);
                h12 = c0Var.h(8);
            } else {
                int h13 = c0Var.h(7);
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

    private static void j(byte[] bArr, int[] iArr, int i11, int i12, int i13, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        c0 c0Var = new c0(bArr);
        int i14 = i12;
        int i15 = i13;
        byte[] bArr5 = null;
        byte[] bArr6 = null;
        byte[] bArr7 = null;
        while (c0Var.b() != 0) {
            int h11 = c0Var.h(8);
            if (h11 != 240) {
                switch (h11) {
                    case 16:
                        if (i11 != 3) {
                            if (i11 != 2) {
                                bArr2 = null;
                                i14 = g(c0Var, iArr, bArr2, i14, i15, paint, canvas);
                                c0Var.c();
                                break;
                            } else {
                                bArr3 = bArr7 == null ? f61371h : bArr7;
                            }
                        } else {
                            bArr3 = bArr5 == null ? f61372i : bArr5;
                        }
                        bArr2 = bArr3;
                        i14 = g(c0Var, iArr, bArr2, i14, i15, paint, canvas);
                        c0Var.c();
                    case 17:
                        if (i11 == 3) {
                            bArr4 = bArr6 == null ? f61373j : bArr6;
                        } else {
                            bArr4 = null;
                        }
                        i14 = h(c0Var, iArr, bArr4, i14, i15, paint, canvas);
                        c0Var.c();
                        break;
                    case 18:
                        i14 = i(c0Var, iArr, null, i14, i15, paint, canvas);
                        break;
                    default:
                        switch (h11) {
                            case 32:
                                bArr7 = a(4, 4, c0Var);
                                break;
                            case 33:
                                bArr5 = a(4, 8, c0Var);
                                break;
                            case 34:
                                bArr6 = a(16, 8, c0Var);
                                break;
                        }
                }
            } else {
                i15 += 2;
                i14 = i12;
            }
        }
    }

    private static void k(c cVar, a aVar, int i11, int i12, int i13, Paint paint, Canvas canvas) {
        int[] iArr = i11 == 3 ? aVar.f61384d : i11 == 2 ? aVar.f61383c : aVar.f61382b;
        j(cVar.f61393c, iArr, i11, i12, i13, paint, canvas);
        j(cVar.f61394d, iArr, i11, i12, i13 + 1, paint, canvas);
    }

    private static a l(c0 c0Var, int i11) {
        int h11;
        int i12;
        int h12;
        int i13;
        int i14;
        int i15 = 8;
        int h13 = c0Var.h(8);
        c0Var.r(8);
        int i16 = 2;
        int i17 = i11 - 2;
        int[] c11 = c();
        int[] d11 = d();
        int[] e11 = e();
        while (i17 > 0) {
            int h14 = c0Var.h(i15);
            int h15 = c0Var.h(i15);
            int[] iArr = (h15 & 128) != 0 ? c11 : (h15 & 64) != 0 ? d11 : e11;
            if ((h15 & 1) != 0) {
                i13 = c0Var.h(i15);
                i14 = c0Var.h(i15);
                h11 = c0Var.h(i15);
                h12 = c0Var.h(i15);
                i12 = i17 - 6;
            } else {
                int h16 = c0Var.h(6) << i16;
                int h17 = c0Var.h(4) << 4;
                h11 = c0Var.h(4) << 4;
                i12 = i17 - 4;
                h12 = c0Var.h(i16) << 6;
                i13 = h16;
                i14 = h17;
            }
            if (i13 == 0) {
                h12 = 255;
                i14 = 0;
                h11 = 0;
            }
            double d12 = i13;
            double d13 = i14 - 128;
            double d14 = h11 - 128;
            iArr[h14] = f((byte) (255 - (h12 & 255)), p0.q((int) (d12 + (1.402d * d13)), 0, 255), p0.q((int) ((d12 - (0.34414d * d14)) - (d13 * 0.71414d)), 0, 255), p0.q((int) (d12 + (d14 * 1.772d)), 0, 255));
            i17 = i12;
            h13 = h13;
            i15 = 8;
            i16 = 2;
        }
        return new a(h13, c11, d11, e11);
    }

    private static C0756b m(c0 c0Var) {
        int i11;
        int i12;
        int i13;
        int i14;
        c0Var.r(4);
        boolean g11 = c0Var.g();
        c0Var.r(3);
        int h11 = c0Var.h(16);
        int h12 = c0Var.h(16);
        if (g11) {
            int h13 = c0Var.h(16);
            int h14 = c0Var.h(16);
            int h15 = c0Var.h(16);
            i14 = c0Var.h(16);
            i13 = h14;
            i12 = h15;
            i11 = h13;
        } else {
            i11 = 0;
            i12 = 0;
            i13 = h11;
            i14 = h12;
        }
        return new C0756b(h11, h12, i11, i13, i12, i14);
    }

    private static c n(c0 c0Var) {
        byte[] bArr;
        int h11 = c0Var.h(16);
        c0Var.r(4);
        int h12 = c0Var.h(2);
        boolean g11 = c0Var.g();
        c0Var.r(1);
        byte[] bArr2 = p0.f27685f;
        if (h12 == 1) {
            c0Var.r(c0Var.h(8) * 16);
        } else if (h12 == 0) {
            int h13 = c0Var.h(16);
            int h14 = c0Var.h(16);
            if (h13 > 0) {
                bArr2 = new byte[h13];
                c0Var.k(bArr2, 0, h13);
            }
            if (h14 > 0) {
                bArr = new byte[h14];
                c0Var.k(bArr, 0, h14);
                return new c(h11, g11, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new c(h11, g11, bArr2, bArr);
    }

    private static d o(c0 c0Var, int i11) {
        int h11 = c0Var.h(8);
        int h12 = c0Var.h(4);
        int h13 = c0Var.h(2);
        c0Var.r(2);
        int i12 = i11 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i12 > 0) {
            int h14 = c0Var.h(8);
            c0Var.r(8);
            i12 -= 6;
            sparseArray.put(h14, new e(c0Var.h(16), c0Var.h(16)));
        }
        return new d(h11, h12, h13, sparseArray);
    }

    private static f p(c0 c0Var, int i11) {
        int i12;
        int i13;
        int i14;
        int h11 = c0Var.h(8);
        c0Var.r(4);
        boolean g11 = c0Var.g();
        c0Var.r(3);
        int i15 = 16;
        int h12 = c0Var.h(16);
        int h13 = c0Var.h(16);
        int h14 = c0Var.h(3);
        int h15 = c0Var.h(3);
        int i16 = 2;
        c0Var.r(2);
        int h16 = c0Var.h(8);
        int h17 = c0Var.h(8);
        int h18 = c0Var.h(4);
        int h19 = c0Var.h(2);
        c0Var.r(2);
        int i17 = i11 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i17 > 0) {
            int h20 = c0Var.h(i15);
            int h21 = c0Var.h(i16);
            int h22 = c0Var.h(i16);
            int h23 = c0Var.h(12);
            int i18 = h19;
            c0Var.r(4);
            int h24 = c0Var.h(12);
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
            i14 = c0Var.h(8);
            i13 = c0Var.h(8);
            sparseArray.put(h20, new g(h21, h22, h23, h24, i14, i13));
            i16 = i12;
            h19 = i18;
            i15 = 16;
        }
        return new f(h11, g11, h12, h13, h14, h15, h16, h17, h18, h19, sparseArray);
    }

    private static void q(c0 c0Var, h hVar) {
        f fVar;
        int h11 = c0Var.h(8);
        int h12 = c0Var.h(16);
        int h13 = c0Var.h(16);
        int d11 = c0Var.d() + h13;
        if (h13 * 8 > c0Var.b()) {
            s.i("DvbParser", "Data field length exceeds limit");
            c0Var.r(c0Var.b());
            return;
        }
        switch (h11) {
            case 16:
                if (h12 == hVar.f61418a) {
                    d dVar = hVar.f61426i;
                    d o11 = o(c0Var, h13);
                    if (o11.f61397c == 0) {
                        if (dVar != null && dVar.f61396b != o11.f61396b) {
                            hVar.f61426i = o11;
                            break;
                        }
                    } else {
                        hVar.f61426i = o11;
                        hVar.f61420c.clear();
                        hVar.f61421d.clear();
                        hVar.f61422e.clear();
                        break;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.f61426i;
                if (h12 == hVar.f61418a && dVar2 != null) {
                    f p11 = p(c0Var, h13);
                    if (dVar2.f61397c == 0 && (fVar = (f) hVar.f61420c.get(p11.f61401a)) != null) {
                        p11.a(fVar);
                    }
                    hVar.f61420c.put(p11.f61401a, p11);
                    break;
                }
                break;
            case 18:
                if (h12 != hVar.f61418a) {
                    if (h12 == hVar.f61419b) {
                        a l11 = l(c0Var, h13);
                        hVar.f61423f.put(l11.f61381a, l11);
                        break;
                    }
                } else {
                    a l12 = l(c0Var, h13);
                    hVar.f61421d.put(l12.f61381a, l12);
                    break;
                }
                break;
            case 19:
                if (h12 != hVar.f61418a) {
                    if (h12 == hVar.f61419b) {
                        c n11 = n(c0Var);
                        hVar.f61424g.put(n11.f61391a, n11);
                        break;
                    }
                } else {
                    c n12 = n(c0Var);
                    hVar.f61422e.put(n12.f61391a, n12);
                    break;
                }
                break;
            case 20:
                if (h12 == hVar.f61418a) {
                    hVar.f61425h = m(c0Var);
                    break;
                }
                break;
        }
        c0Var.s(d11 - c0Var.d());
    }

    public List b(byte[] bArr, int i11) {
        int i12;
        SparseArray sparseArray;
        c0 c0Var = new c0(bArr, i11);
        while (c0Var.b() >= 48 && c0Var.h(8) == 15) {
            q(c0Var, this.f61379f);
        }
        h hVar = this.f61379f;
        d dVar = hVar.f61426i;
        if (dVar == null) {
            return Collections.emptyList();
        }
        C0756b c0756b = hVar.f61425h;
        if (c0756b == null) {
            c0756b = this.f61377d;
        }
        Bitmap bitmap = this.f61380g;
        if (bitmap == null || c0756b.f61385a + 1 != bitmap.getWidth() || c0756b.f61386b + 1 != this.f61380g.getHeight()) {
            Bitmap createBitmap = Bitmap.createBitmap(c0756b.f61385a + 1, c0756b.f61386b + 1, Bitmap.Config.ARGB_8888);
            this.f61380g = createBitmap;
            this.f61376c.setBitmap(createBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray sparseArray2 = dVar.f61398d;
        for (int i13 = 0; i13 < sparseArray2.size(); i13++) {
            this.f61376c.save();
            e eVar = (e) sparseArray2.valueAt(i13);
            f fVar = (f) this.f61379f.f61420c.get(sparseArray2.keyAt(i13));
            int i14 = eVar.f61399a + c0756b.f61387c;
            int i15 = eVar.f61400b + c0756b.f61389e;
            this.f61376c.clipRect(i14, i15, Math.min(fVar.f61403c + i14, c0756b.f61388d), Math.min(fVar.f61404d + i15, c0756b.f61390f));
            a aVar = (a) this.f61379f.f61421d.get(fVar.f61407g);
            if (aVar == null && (aVar = (a) this.f61379f.f61423f.get(fVar.f61407g)) == null) {
                aVar = this.f61378e;
            }
            SparseArray sparseArray3 = fVar.f61411k;
            int i16 = 0;
            while (i16 < sparseArray3.size()) {
                int keyAt = sparseArray3.keyAt(i16);
                g gVar = (g) sparseArray3.valueAt(i16);
                c cVar = (c) this.f61379f.f61422e.get(keyAt);
                c cVar2 = cVar == null ? (c) this.f61379f.f61424g.get(keyAt) : cVar;
                if (cVar2 != null) {
                    i12 = i16;
                    sparseArray = sparseArray3;
                    k(cVar2, aVar, fVar.f61406f, gVar.f61414c + i14, i15 + gVar.f61415d, cVar2.f61392b ? null : this.f61374a, this.f61376c);
                } else {
                    i12 = i16;
                    sparseArray = sparseArray3;
                }
                i16 = i12 + 1;
                sparseArray3 = sparseArray;
            }
            if (fVar.f61402b) {
                int i17 = fVar.f61406f;
                this.f61375b.setColor(i17 == 3 ? aVar.f61384d[fVar.f61408h] : i17 == 2 ? aVar.f61383c[fVar.f61409i] : aVar.f61382b[fVar.f61410j]);
                this.f61376c.drawRect(i14, i15, fVar.f61403c + i14, fVar.f61404d + i15, this.f61375b);
            }
            arrayList.add(new b.C0151b().f(Bitmap.createBitmap(this.f61380g, i14, i15, fVar.f61403c, fVar.f61404d)).k(i14 / c0756b.f61385a).l(0).h(i15 / c0756b.f61386b, 0).i(0).n(fVar.f61403c / c0756b.f61385a).g(fVar.f61404d / c0756b.f61386b).a());
            this.f61376c.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f61376c.restore();
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void r() {
        this.f61379f.a();
    }
}
