package s6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public abstract class a {
    public static final View a(ViewGroup viewGroup, int i11) {
        Intrinsics.h(viewGroup, "<this>");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, false);
        Intrinsics.g(inflate, "from(this.context).infla…layoutResId, this, false)");
        return inflate;
    }
}
