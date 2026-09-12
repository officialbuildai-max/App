package yd;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.g;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private Mode f79109a;

    /* renamed from: b, reason: collision with root package name */
    private ErrorCorrectionLevel f79110b;

    /* renamed from: c, reason: collision with root package name */
    private g f79111c;

    /* renamed from: d, reason: collision with root package name */
    private int f79112d = -1;

    /* renamed from: e, reason: collision with root package name */
    private a f79113e;

    public static boolean b(int i11) {
        return i11 >= 0 && i11 < 8;
    }

    public a a() {
        return this.f79113e;
    }

    public void c(ErrorCorrectionLevel errorCorrectionLevel) {
        this.f79110b = errorCorrectionLevel;
    }

    public void d(int i11) {
        this.f79112d = i11;
    }

    public void e(a aVar) {
        this.f79113e = aVar;
    }

    public void f(Mode mode) {
        this.f79109a = mode;
    }

    public void g(g gVar) {
        this.f79111c = gVar;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(200);
        sb2.append("<<\n");
        sb2.append(" mode: ");
        sb2.append(this.f79109a);
        sb2.append("\n ecLevel: ");
        sb2.append(this.f79110b);
        sb2.append("\n version: ");
        sb2.append(this.f79111c);
        sb2.append("\n maskPattern: ");
        sb2.append(this.f79112d);
        if (this.f79113e == null) {
            sb2.append("\n matrix: null\n");
        } else {
            sb2.append("\n matrix:\n");
            sb2.append(this.f79113e);
        }
        sb2.append(">>\n");
        return sb2.toString();
    }
}
