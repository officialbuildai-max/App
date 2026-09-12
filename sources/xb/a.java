package xb;

/* loaded from: classes5.dex */
public class a implements d {

    /* renamed from: a, reason: collision with root package name */
    private final int f78303a;

    /* renamed from: b, reason: collision with root package name */
    private final d[] f78304b;

    /* renamed from: c, reason: collision with root package name */
    private final b f78305c;

    public a(int i11, d... dVarArr) {
        this.f78303a = i11;
        this.f78304b = dVarArr;
        this.f78305c = new b(i11);
    }

    @Override // xb.d
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.f78303a) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        for (d dVar : this.f78304b) {
            if (stackTraceElementArr2.length <= this.f78303a) {
                break;
            }
            stackTraceElementArr2 = dVar.a(stackTraceElementArr);
        }
        return stackTraceElementArr2.length > this.f78303a ? this.f78305c.a(stackTraceElementArr2) : stackTraceElementArr2;
    }
}
