package xb;

/* loaded from: classes5.dex */
public class b implements d {

    /* renamed from: a, reason: collision with root package name */
    private final int f78306a;

    public b(int i11) {
        this.f78306a = i11;
    }

    @Override // xb.d
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        int length = stackTraceElementArr.length;
        int i11 = this.f78306a;
        if (length <= i11) {
            return stackTraceElementArr;
        }
        int i12 = i11 / 2;
        int i13 = i11 - i12;
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[i11];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, i13);
        System.arraycopy(stackTraceElementArr, stackTraceElementArr.length - i12, stackTraceElementArr2, i13, i12);
        return stackTraceElementArr2;
    }
}
