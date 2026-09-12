package com.transsion.publish.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$layout;
import com.transsion.publish.api.VsMediaInfo;
import com.transsion.publish.ui.SelectVideoActivity;
import com.transsion.publish.ui.VideoPreviewActivity;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import ej.f;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.mvel2.ast.ASTNode;

/* loaded from: classes6.dex */
public final class v extends RecyclerView.Adapter {

    /* renamed from: e, reason: collision with root package name */
    public static final a f50484e = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private FrameLayout.LayoutParams f50486b;

    /* renamed from: d, reason: collision with root package name */
    private boolean f50488d;

    /* renamed from: a, reason: collision with root package name */
    private List f50485a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private int f50487c = (com.blankj.utilcode.util.y.b() - (com.blankj.utilcode.util.a0.a(3.0f) * 5)) / 4;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public v() {
        int i11 = this.f50487c;
        this.f50486b = new FrameLayout.LayoutParams(i11, i11);
    }

    private final void j(final l0 l0Var, VsMediaInfo vsMediaInfo) {
        TextView i11 = l0Var.i();
        if (i11 != null) {
            i11.setVisibility(4);
        }
        View f11 = l0Var.f();
        if (f11 != null) {
            f11.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v.k(l0.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(l0 l0Var, View view) {
        Intent intent = new Intent(l0Var.itemView.getContext(), (Class<?>) SelectVideoActivity.class);
        intent.setFlags(ASTNode.DEOP);
        l0Var.itemView.getContext().startActivity(intent);
    }

    private final void o(final l0 l0Var, final VsMediaInfo vsMediaInfo, int i11) {
        l0Var.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v.p(l0.this, vsMediaInfo, view);
            }
        });
        View g11 = l0Var.g();
        if (g11 != null) {
            g11.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v.q(v.this, view);
                }
            });
        }
        if (!TextUtils.isEmpty(vsMediaInfo.getImagePath())) {
            ImageView h11 = l0Var.h();
            if (h11 != null) {
                f.a aVar = ej.f.f62005a;
                Context context = l0Var.itemView.getContext();
                Intrinsics.g(context, "getContext(...)");
                aVar.m(context).g(vsMediaInfo.getImagePath()).i(R$drawable.upload_error_cover).j(4).d(h11);
                return;
            }
            return;
        }
        File file = new File(vsMediaInfo.getVideoPath());
        ImageView h12 = l0Var.h();
        if (h12 != null) {
            f.a aVar2 = ej.f.f62005a;
            Context context2 = l0Var.itemView.getContext();
            Intrinsics.g(context2, "getContext(...)");
            aVar2.m(context2).g(Uri.fromFile(file).toString()).i(R$drawable.upload_error_cover).j(4).d(h12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(l0 l0Var, VsMediaInfo vsMediaInfo, View view) {
        VideoPreviewActivity.Companion companion = VideoPreviewActivity.INSTANCE;
        Context context = l0Var.itemView.getContext();
        Intrinsics.g(context, "getContext(...)");
        companion.a(context, vsMediaInfo, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(v vVar, View view) {
        if (vVar.f50488d) {
            return;
        }
        vVar.f50488d = false;
        fp.a aVar = new fp.a();
        aVar.o(1);
        aVar.n(2);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = fp.a.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.postEvent(name, aVar, 0L);
        vVar.notifyDataSetChanged();
        vVar.f50488d = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f50485a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i11) {
        return ((VsMediaInfo) this.f50485a.get(i11)).getIsAdd() ? 2 : 1;
    }

    public final List l() {
        ArrayList arrayList = new ArrayList();
        List<VsMediaInfo> list = this.f50485a;
        if (list != null) {
            for (VsMediaInfo vsMediaInfo : list) {
                if (!vsMediaInfo.getIsAdd()) {
                    arrayList.add(vsMediaInfo);
                }
            }
        }
        return arrayList;
    }

    public final List m() {
        return this.f50485a;
    }

    public final boolean n() {
        List list = this.f50485a;
        return list != null && list.isEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(l0 holder, int i11) {
        Intrinsics.h(holder, "holder");
        VsMediaInfo vsMediaInfo = (VsMediaInfo) this.f50485a.get(i11);
        if (vsMediaInfo.getIsAdd()) {
            j(holder, vsMediaInfo);
        } else {
            o(holder, vsMediaInfo, i11);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public l0 onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        return i11 != 1 ? i11 != 2 ? new l0(null) : new l0(LayoutInflater.from(parent.getContext()).inflate(R$layout.item_publish_add_video, (ViewGroup) null)) : new l0(LayoutInflater.from(parent.getContext()).inflate(R$layout.item_publish_video, (ViewGroup) null));
    }

    public final void setData(List data) {
        Intrinsics.h(data, "data");
        this.f50485a.clear();
        this.f50485a.addAll(data);
        notifyDataSetChanged();
    }

    public final void t() {
        List list = this.f50485a;
        if (list != null) {
            list.clear();
        }
        notifyDataSetChanged();
    }
}
