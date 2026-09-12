package androidx.palette.graphics;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.Log;
import android.util.SparseBooleanArray;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    static final c f14065f = new C0116a();

    /* renamed from: a, reason: collision with root package name */
    private final List f14066a;

    /* renamed from: b, reason: collision with root package name */
    private final List f14067b;

    /* renamed from: d, reason: collision with root package name */
    private final SparseBooleanArray f14069d = new SparseBooleanArray();

    /* renamed from: c, reason: collision with root package name */
    private final Map f14068c = new androidx.collection.a();

    /* renamed from: e, reason: collision with root package name */
    private final e f14070e = a();

    /* renamed from: androidx.palette.graphics.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0116a implements c {
        C0116a() {
        }

        private boolean b(float[] fArr) {
            return fArr[2] <= 0.05f;
        }

        private boolean c(float[] fArr) {
            float f11 = fArr[0];
            return f11 >= 10.0f && f11 <= 37.0f && fArr[1] <= 0.82f;
        }

        private boolean d(float[] fArr) {
            return fArr[2] >= 0.95f;
        }

        @Override // androidx.palette.graphics.a.c
        public boolean a(int i11, float[] fArr) {
            return (d(fArr) || b(fArr) || c(fArr)) ? false : true;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final List f14071a;

        /* renamed from: b, reason: collision with root package name */
        private final Bitmap f14072b;

        /* renamed from: c, reason: collision with root package name */
        private final List f14073c;

        /* renamed from: d, reason: collision with root package name */
        private int f14074d;

        /* renamed from: e, reason: collision with root package name */
        private int f14075e;

        /* renamed from: f, reason: collision with root package name */
        private int f14076f;

        /* renamed from: g, reason: collision with root package name */
        private final List f14077g;

        /* renamed from: h, reason: collision with root package name */
        private Rect f14078h;

        /* renamed from: androidx.palette.graphics.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class AsyncTaskC0117a extends AsyncTask {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f14079a;

            AsyncTaskC0117a(d dVar) {
                this.f14079a = dVar;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a doInBackground(Bitmap... bitmapArr) {
                try {
                    return b.this.c();
                } catch (Exception e11) {
                    Log.e("Palette", "Exception thrown during async generate", e11);
                    return null;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(a aVar) {
                this.f14079a.a(aVar);
            }
        }

        public b(Bitmap bitmap) {
            ArrayList arrayList = new ArrayList();
            this.f14073c = arrayList;
            this.f14074d = 16;
            this.f14075e = 12544;
            this.f14076f = -1;
            ArrayList arrayList2 = new ArrayList();
            this.f14077g = arrayList2;
            if (bitmap == null || bitmap.isRecycled()) {
                throw new IllegalArgumentException("Bitmap is not valid");
            }
            arrayList2.add(a.f14065f);
            this.f14072b = bitmap;
            this.f14071a = null;
            arrayList.add(androidx.palette.graphics.b.f14090e);
            arrayList.add(androidx.palette.graphics.b.f14091f);
            arrayList.add(androidx.palette.graphics.b.f14092g);
            arrayList.add(androidx.palette.graphics.b.f14093h);
            arrayList.add(androidx.palette.graphics.b.f14094i);
            arrayList.add(androidx.palette.graphics.b.f14095j);
        }

        private int[] d(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            Rect rect = this.f14078h;
            if (rect == null) {
                return iArr;
            }
            int width2 = rect.width();
            int height2 = this.f14078h.height();
            int[] iArr2 = new int[width2 * height2];
            for (int i11 = 0; i11 < height2; i11++) {
                Rect rect2 = this.f14078h;
                System.arraycopy(iArr, ((rect2.top + i11) * width) + rect2.left, iArr2, i11 * width2, width2);
            }
            return iArr2;
        }

        private Bitmap e(Bitmap bitmap) {
            int max;
            int i11;
            double d11 = -1.0d;
            if (this.f14075e > 0) {
                int width = bitmap.getWidth() * bitmap.getHeight();
                int i12 = this.f14075e;
                if (width > i12) {
                    d11 = Math.sqrt(i12 / width);
                }
            } else if (this.f14076f > 0 && (max = Math.max(bitmap.getWidth(), bitmap.getHeight())) > (i11 = this.f14076f)) {
                d11 = i11 / max;
            }
            return d11 <= 0.0d ? bitmap : Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * d11), (int) Math.ceil(bitmap.getHeight() * d11), false);
        }

        public b a() {
            this.f14077g.clear();
            return this;
        }

        public AsyncTask b(d dVar) {
            if (dVar != null) {
                return new AsyncTaskC0117a(dVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f14072b);
            }
            throw new IllegalArgumentException("listener can not be null");
        }

        public a c() {
            List list;
            c[] cVarArr;
            Bitmap bitmap = this.f14072b;
            if (bitmap != null) {
                Bitmap e11 = e(bitmap);
                Rect rect = this.f14078h;
                if (e11 != this.f14072b && rect != null) {
                    double width = e11.getWidth() / this.f14072b.getWidth();
                    rect.left = (int) Math.floor(rect.left * width);
                    rect.top = (int) Math.floor(rect.top * width);
                    rect.right = Math.min((int) Math.ceil(rect.right * width), e11.getWidth());
                    rect.bottom = Math.min((int) Math.ceil(rect.bottom * width), e11.getHeight());
                }
                int[] d11 = d(e11);
                int i11 = this.f14074d;
                if (this.f14077g.isEmpty()) {
                    cVarArr = null;
                } else {
                    List list2 = this.f14077g;
                    cVarArr = (c[]) list2.toArray(new c[list2.size()]);
                }
                ColorCutQuantizer colorCutQuantizer = new ColorCutQuantizer(d11, i11, cVarArr);
                if (e11 != this.f14072b) {
                    e11.recycle();
                }
                list = colorCutQuantizer.d();
            } else {
                list = this.f14071a;
                if (list == null) {
                    throw new AssertionError();
                }
            }
            a aVar = new a(list, this.f14073c);
            aVar.c();
            return aVar;
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        boolean a(int i11, float[] fArr);
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(a aVar);
    }

    /* loaded from: classes2.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        private final int f14081a;

        /* renamed from: b, reason: collision with root package name */
        private final int f14082b;

        /* renamed from: c, reason: collision with root package name */
        private final int f14083c;

        /* renamed from: d, reason: collision with root package name */
        private final int f14084d;

        /* renamed from: e, reason: collision with root package name */
        private final int f14085e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f14086f;

        /* renamed from: g, reason: collision with root package name */
        private int f14087g;

        /* renamed from: h, reason: collision with root package name */
        private int f14088h;

        /* renamed from: i, reason: collision with root package name */
        private float[] f14089i;

        public e(int i11, int i12) {
            this.f14081a = Color.red(i11);
            this.f14082b = Color.green(i11);
            this.f14083c = Color.blue(i11);
            this.f14084d = i11;
            this.f14085e = i12;
        }

        private void a() {
            if (this.f14086f) {
                return;
            }
            int g11 = z0.b.g(-1, this.f14084d, 4.5f);
            int g12 = z0.b.g(-1, this.f14084d, 3.0f);
            if (g11 != -1 && g12 != -1) {
                this.f14088h = z0.b.p(-1, g11);
                this.f14087g = z0.b.p(-1, g12);
                this.f14086f = true;
                return;
            }
            int g13 = z0.b.g(ViewCompat.MEASURED_STATE_MASK, this.f14084d, 4.5f);
            int g14 = z0.b.g(ViewCompat.MEASURED_STATE_MASK, this.f14084d, 3.0f);
            if (g13 == -1 || g14 == -1) {
                this.f14088h = g11 != -1 ? z0.b.p(-1, g11) : z0.b.p(ViewCompat.MEASURED_STATE_MASK, g13);
                this.f14087g = g12 != -1 ? z0.b.p(-1, g12) : z0.b.p(ViewCompat.MEASURED_STATE_MASK, g14);
                this.f14086f = true;
            } else {
                this.f14088h = z0.b.p(ViewCompat.MEASURED_STATE_MASK, g13);
                this.f14087g = z0.b.p(ViewCompat.MEASURED_STATE_MASK, g14);
                this.f14086f = true;
            }
        }

        public int b() {
            a();
            return this.f14088h;
        }

        public float[] c() {
            if (this.f14089i == null) {
                this.f14089i = new float[3];
            }
            z0.b.a(this.f14081a, this.f14082b, this.f14083c, this.f14089i);
            return this.f14089i;
        }

        public int d() {
            return this.f14085e;
        }

        public int e() {
            return this.f14084d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.f14085e == eVar.f14085e && this.f14084d == eVar.f14084d;
        }

        public int f() {
            a();
            return this.f14087g;
        }

        public int hashCode() {
            return (this.f14084d * 31) + this.f14085e;
        }

        public String toString() {
            return e.class.getSimpleName() + " [RGB: #" + Integer.toHexString(e()) + "] [HSL: " + Arrays.toString(c()) + "] [Population: " + this.f14085e + "] [Title Text: #" + Integer.toHexString(f()) + "] [Body Text: #" + Integer.toHexString(b()) + ']';
        }
    }

    a(List list, List list2) {
        this.f14066a = list;
        this.f14067b = list2;
    }

    private e a() {
        int size = this.f14066a.size();
        int i11 = Integer.MIN_VALUE;
        e eVar = null;
        for (int i12 = 0; i12 < size; i12++) {
            e eVar2 = (e) this.f14066a.get(i12);
            if (eVar2.d() > i11) {
                i11 = eVar2.d();
                eVar = eVar2;
            }
        }
        return eVar;
    }

    public static b b(Bitmap bitmap) {
        return new b(bitmap);
    }

    private float d(e eVar, androidx.palette.graphics.b bVar) {
        float[] c11 = eVar.c();
        e eVar2 = this.f14070e;
        return (bVar.g() > 0.0f ? bVar.g() * (1.0f - Math.abs(c11[1] - bVar.i())) : 0.0f) + (bVar.a() > 0.0f ? bVar.a() * (1.0f - Math.abs(c11[2] - bVar.h())) : 0.0f) + (bVar.f() > 0.0f ? bVar.f() * (eVar.d() / (eVar2 != null ? eVar2.d() : 1)) : 0.0f);
    }

    private e e(androidx.palette.graphics.b bVar) {
        e l11 = l(bVar);
        if (l11 != null && bVar.j()) {
            this.f14069d.append(l11.e(), true);
        }
        return l11;
    }

    private e l(androidx.palette.graphics.b bVar) {
        int size = this.f14066a.size();
        float f11 = 0.0f;
        e eVar = null;
        for (int i11 = 0; i11 < size; i11++) {
            e eVar2 = (e) this.f14066a.get(i11);
            if (p(eVar2, bVar)) {
                float d11 = d(eVar2, bVar);
                if (eVar == null || d11 > f11) {
                    eVar = eVar2;
                    f11 = d11;
                }
            }
        }
        return eVar;
    }

    private boolean p(e eVar, androidx.palette.graphics.b bVar) {
        float[] c11 = eVar.c();
        return c11[1] >= bVar.e() && c11[1] <= bVar.c() && c11[2] >= bVar.d() && c11[2] <= bVar.b() && !this.f14069d.get(eVar.e());
    }

    void c() {
        int size = this.f14067b.size();
        for (int i11 = 0; i11 < size; i11++) {
            androidx.palette.graphics.b bVar = (androidx.palette.graphics.b) this.f14067b.get(i11);
            bVar.k();
            this.f14068c.put(bVar, e(bVar));
        }
        this.f14069d.clear();
    }

    public e f() {
        return n(androidx.palette.graphics.b.f14095j);
    }

    public e g() {
        return n(androidx.palette.graphics.b.f14092g);
    }

    public int h(int i11) {
        e eVar = this.f14070e;
        return eVar != null ? eVar.e() : i11;
    }

    public e i() {
        return this.f14070e;
    }

    public e j() {
        return n(androidx.palette.graphics.b.f14093h);
    }

    public e k() {
        return n(androidx.palette.graphics.b.f14090e);
    }

    public e m() {
        return n(androidx.palette.graphics.b.f14094i);
    }

    public e n(androidx.palette.graphics.b bVar) {
        return (e) this.f14068c.get(bVar);
    }

    public e o() {
        return n(androidx.palette.graphics.b.f14091f);
    }
}
