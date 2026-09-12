package op;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.widget.TnTextView;
import com.transsion.publish.R$id;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class g extends RecyclerView.b0 {

    /* renamed from: a, reason: collision with root package name */
    private View f71213a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f71214b;

    /* renamed from: c, reason: collision with root package name */
    private TnTextView f71215c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(View itemView) {
        super(itemView);
        Intrinsics.h(itemView, "itemView");
        this.f71213a = itemView;
        View findViewById = itemView.findViewById(R$id.image);
        Intrinsics.g(findViewById, "findViewById(...)");
        this.f71214b = (ImageView) findViewById;
        View findViewById2 = itemView.findViewById(R$id.desc);
        Intrinsics.g(findViewById2, "findViewById(...)");
        this.f71215c = (TnTextView) findViewById2;
    }

    public final TnTextView f() {
        return this.f71215c;
    }

    public final ImageView g() {
        return this.f71214b;
    }

    public final View h() {
        return this.f71213a;
    }
}
