package v4;

import android.util.Log;
import com.airbnb.lottie.n0;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class e implements n0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Set f77145a = new HashSet();

    @Override // com.airbnb.lottie.n0
    public void a(String str) {
        d(str, null);
    }

    @Override // com.airbnb.lottie.n0
    public void b(String str, Throwable th2) {
        boolean z10 = com.airbnb.lottie.d.f17792a;
    }

    @Override // com.airbnb.lottie.n0
    public void c(String str) {
        e(str, null);
    }

    @Override // com.airbnb.lottie.n0
    public void d(String str, Throwable th2) {
        Set set = f77145a;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, th2);
        set.add(str);
    }

    public void e(String str, Throwable th2) {
        boolean z10 = com.airbnb.lottie.d.f17792a;
    }
}
