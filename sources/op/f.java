package op;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$id;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class f extends RecyclerView.b0 {

    /* renamed from: a, reason: collision with root package name */
    private View f71211a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f71212b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(View itemView) {
        super(itemView);
        Intrinsics.h(itemView, "itemView");
        this.f71211a = itemView;
        View findViewById = itemView.findViewById(R$id.image);
        Intrinsics.g(findViewById, "findViewById(...)");
        this.f71212b = (ImageView) findViewById;
    }

    public final ImageView f() {
        return this.f71212b;
    }

    public final View g() {
        return this.f71211a;
    }
}
