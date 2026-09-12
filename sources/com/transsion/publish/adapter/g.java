package com.transsion.publish.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$layout;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.ui.GalleryActivity;
import com.transsion.publish.ui.SelectImageActivity;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class g extends RecyclerView.Adapter {

    /* renamed from: e, reason: collision with root package name */
    public static final a f50417e = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private FrameLayout.LayoutParams f50419b;

    /* renamed from: d, reason: collision with root package name */
    private boolean f50421d;

    /* renamed from: a, reason: collision with root package name */
    private List f50418a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private int f50420c = (com.blankj.utilcode.util.y.b() - (com.blankj.utilcode.util.a0.a(3.0f) * 5)) / 4;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public g() {
        int i11 = this.f50420c;
        this.f50419b = new FrameLayout.LayoutParams(i11, i11);
    }

    private final void j(final c cVar, PhotoEntity photoEntity) {
        if (getItemCount() == 0) {
            TextView i11 = cVar.i();
            if (i11 != null) {
                i11.setText("0/9");
            }
        } else {
            List list = this.f50418a;
            boolean z10 = false;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((PhotoEntity) it.next()).getIsAdd()) {
                        z10 = true;
                    }
                }
            }
            if (z10) {
                TextView i12 = cVar.i();
                if (i12 != null) {
                    i12.setText((getItemCount() - 1) + "/9");
                }
            } else {
                TextView i13 = cVar.i();
                if (i13 != null) {
                    i13.setText(getItemCount() + "/9");
                }
            }
        }
        View f11 = cVar.f();
        if (f11 != null) {
            f11.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.k(c.this, this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(c cVar, g gVar, View view) {
        Context context;
        View f11 = cVar.f();
        if (f11 == null || (context = f11.getContext()) == null) {
            return;
        }
        SelectImageActivity.INSTANCE.a(context, 0, 9 - gVar.l().size(), new ArrayList());
    }

    private final void o(final c cVar, final PhotoEntity photoEntity, final int i11) {
        ImageView h11 = cVar.h();
        if (h11 != null) {
            Glide.with(cVar.itemView.getContext()).load2(photoEntity.getLocalPath()).placeholder(R$drawable.upload_error_cover).into(h11);
        }
        cVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.p(g.this, cVar, i11, view);
            }
        });
        View g11 = cVar.g();
        if (g11 != null) {
            g11.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.q(g.this, photoEntity, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(g gVar, c cVar, int i11, View view) {
        List l11 = gVar.l();
        com.transsion.publish.n.f50509b.a().f(l11);
        GalleryActivity.Companion companion = GalleryActivity.INSTANCE;
        Context context = cVar.itemView.getContext();
        Intrinsics.g(context, "getContext(...)");
        companion.a(context, l11, i11, 2, 9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(g gVar, PhotoEntity photoEntity, View view) {
        if (gVar.f50421d) {
            return;
        }
        gVar.f50421d = false;
        gVar.t(photoEntity);
        gVar.f50421d = false;
    }

    private final void t(PhotoEntity photoEntity) {
        this.f50418a.remove(photoEntity);
        fp.a aVar = new fp.a();
        boolean z10 = false;
        aVar.o(0);
        aVar.n(2);
        if (this.f50418a.size() == 0 || (this.f50418a.size() == 1 && ((PhotoEntity) this.f50418a.get(0)).getIsAdd())) {
            List list = this.f50418a;
            if (list != null) {
                list.clear();
            }
            notifyDataSetChanged();
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = fp.a.class.getName();
            Intrinsics.g(name, "getName(...)");
            flowEventBus.postEvent(name, aVar, 0L);
            return;
        }
        if (this.f50418a.size() == 8) {
            Iterator it = this.f50418a.iterator();
            while (it.hasNext()) {
                if (((PhotoEntity) it.next()).getIsAdd()) {
                    z10 = true;
                }
            }
            if (!z10) {
                PhotoEntity photoEntity2 = new PhotoEntity();
                photoEntity2.setAdd(true);
                this.f50418a.add(photoEntity2);
            }
        }
        FlowEventBus flowEventBus2 = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = fp.a.class.getName();
        Intrinsics.g(name2, "getName(...)");
        flowEventBus2.postEvent(name2, aVar, 0L);
        notifyDataSetChanged();
    }

    public final void addData(List data) {
        Intrinsics.h(data, "data");
        int size = this.f50418a.size();
        this.f50418a.addAll(data);
        notifyItemRangeInserted(size, data.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f50418a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i11) {
        return ((PhotoEntity) this.f50418a.get(i11)).getIsAdd() ? 2 : 1;
    }

    public final List l() {
        ArrayList arrayList = new ArrayList();
        for (PhotoEntity photoEntity : this.f50418a) {
            if (!photoEntity.getIsAdd()) {
                arrayList.add(photoEntity);
            }
        }
        return arrayList;
    }

    public final List m() {
        return this.f50418a;
    }

    public final boolean n() {
        List list = this.f50418a;
        return list != null && list.isEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c holder, int i11) {
        Intrinsics.h(holder, "holder");
        PhotoEntity photoEntity = (PhotoEntity) this.f50418a.get(i11);
        if (photoEntity.getIsAdd()) {
            j(holder, photoEntity);
        } else {
            o(holder, photoEntity, i11);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        return i11 != 1 ? i11 != 2 ? new c(null) : new c(LayoutInflater.from(parent.getContext()).inflate(R$layout.item_publish_add_image, (ViewGroup) null)) : new c(LayoutInflater.from(parent.getContext()).inflate(R$layout.item_publish_image, (ViewGroup) null));
    }

    public final void setData(List data) {
        Intrinsics.h(data, "data");
        this.f50418a.clear();
        this.f50418a.addAll(data);
        notifyDataSetChanged();
    }

    public final void u() {
        List list = this.f50418a;
        if (list != null) {
            list.clear();
        }
        notifyDataSetChanged();
    }
}
