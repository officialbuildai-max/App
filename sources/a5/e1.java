package a5;

/* loaded from: classes2.dex */
public class e1 {

    /* renamed from: a, reason: collision with root package name */
    public final e1 f269a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f270b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f271c;

    /* renamed from: d, reason: collision with root package name */
    public final int f272d;

    public e1(e1 e1Var, Object obj, Object obj2, int i11, int i12) {
        this.f269a = e1Var;
        this.f270b = obj;
        this.f271c = obj2;
        this.f272d = i11;
    }

    protected void a(StringBuilder sb2) {
        e1 e1Var = this.f269a;
        if (e1Var == null) {
            sb2.append('$');
            return;
        }
        e1Var.a(sb2);
        Object obj = this.f271c;
        if (obj == null) {
            sb2.append(".null");
            return;
        }
        if (obj instanceof Integer) {
            sb2.append('[');
            sb2.append(((Integer) this.f271c).intValue());
            sb2.append(']');
            return;
        }
        sb2.append('.');
        String obj2 = this.f271c.toString();
        for (int i11 = 0; i11 < obj2.length(); i11++) {
            char charAt = obj2.charAt(i11);
            if ((charAt < '0' || charAt > '9') && ((charAt < 'A' || charAt > 'Z') && ((charAt < 'a' || charAt > 'z') && charAt <= 128))) {
                for (int i12 = 0; i12 < obj2.length(); i12++) {
                    char charAt2 = obj2.charAt(i12);
                    if (charAt2 == '\\') {
                        sb2.append('\\');
                        sb2.append('\\');
                        sb2.append('\\');
                    } else if ((charAt2 >= '0' && charAt2 <= '9') || ((charAt2 >= 'A' && charAt2 <= 'Z') || ((charAt2 >= 'a' && charAt2 <= 'z') || charAt2 > 128))) {
                        sb2.append(charAt2);
                    } else if (charAt2 == '\"') {
                        sb2.append('\\');
                        sb2.append('\\');
                        sb2.append('\\');
                    } else {
                        sb2.append('\\');
                        sb2.append('\\');
                    }
                    sb2.append(charAt2);
                }
                return;
            }
        }
        sb2.append(obj2);
    }

    public String toString() {
        if (this.f269a == null) {
            return "$";
        }
        StringBuilder sb2 = new StringBuilder();
        a(sb2);
        return sb2.toString();
    }
}
