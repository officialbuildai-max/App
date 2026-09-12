package xy;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Object f78580a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f78581b = false;

    public a(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("null values in Event are not allowed.");
        }
        this.f78580a = obj;
    }

    public Object a() {
        if (this.f78581b) {
            return null;
        }
        this.f78581b = true;
        return this.f78580a;
    }
}
