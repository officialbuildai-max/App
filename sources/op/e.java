package op;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$layout;
import com.transsion.publish.view.operation.OperationBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class e extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    private List f71209a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private a f71210b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(e eVar, OperationBean operationBean, int i11, View view) {
        a aVar = eVar.f71210b;
        if (aVar != null) {
            aVar.a(operationBean, i11);
        }
    }

    public final void addData(List data) {
        Intrinsics.h(data, "data");
        int size = this.f71209a.size();
        this.f71209a.addAll(data);
        notifyItemRangeInserted(size, data.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f71209a.size();
    }

    public final List h() {
        return this.f71209a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(f holder, final int i11) {
        Intrinsics.h(holder, "holder");
        final OperationBean operationBean = (OperationBean) this.f71209a.get(i11);
        if (operationBean.getStatus()) {
            holder.f().setImageResource(operationBean.getEnable());
        } else {
            holder.f().setImageResource(operationBean.getDisable());
        }
        holder.g().setOnClickListener(new View.OnClickListener() { // from class: op.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.j(e.this, operationBean, i11, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public f onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_operation_layout, parent, false);
        Intrinsics.e(inflate);
        return new f(inflate);
    }

    public final void l(a itemClick) {
        Intrinsics.h(itemClick, "itemClick");
        this.f71210b = itemClick;
    }
}
