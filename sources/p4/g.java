package p4;

/* loaded from: classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final String f72424a;

    /* renamed from: b, reason: collision with root package name */
    public final float f72425b;

    /* renamed from: c, reason: collision with root package name */
    public final float f72426c;

    public g(String str, float f11, float f12) {
        this.f72424a = str;
        this.f72426c = f12;
        this.f72425b = f11;
    }

    public boolean a(String str) {
        if (this.f72424a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f72424a.endsWith("\r")) {
            String str2 = this.f72424a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
