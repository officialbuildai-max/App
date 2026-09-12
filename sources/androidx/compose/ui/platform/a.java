package androidx.compose.ui.platform;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class a implements f {

    /* renamed from: a, reason: collision with root package name */
    protected String f5802a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f5803b = new int[2];

    /* JADX INFO: Access modifiers changed from: protected */
    public final int[] c(int i11, int i12) {
        if (i11 < 0 || i12 < 0 || i11 == i12) {
            return null;
        }
        int[] iArr = this.f5803b;
        iArr[0] = i11;
        iArr[1] = i12;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String d() {
        String str = this.f5802a;
        if (str != null) {
            return str;
        }
        Intrinsics.z(MimeTypes.BASE_TYPE_TEXT);
        return null;
    }

    public void e(String str) {
        f(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f(String str) {
        this.f5802a = str;
    }
}
