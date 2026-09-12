package androidx.compose.ui.graphics;

import android.graphics.Path;
import androidx.compose.ui.graphics.Path;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes.dex */
public abstract class x0 {

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4953a;

        static {
            int[] iArr = new int[Path.Direction.values().length];
            try {
                iArr[Path.Direction.CounterClockwise.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Path.Direction.Clockwise.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f4953a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Path a() {
        return new u0(null, 1, 0 == true ? 1 : 0);
    }

    public static final void c(String str) {
        throw new IllegalStateException(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Path.Direction d(Path.Direction direction) {
        int i11 = a.f4953a[direction.ordinal()];
        if (i11 == 1) {
            return Path.Direction.CCW;
        }
        if (i11 == 2) {
            return Path.Direction.CW;
        }
        throw new NoWhenBranchMatchedException();
    }
}
