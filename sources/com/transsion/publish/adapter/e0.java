package com.transsion.publish.adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.android.gms.gcm.Task;
import com.transsion.baseui.R$mipmap;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$layout;
import com.transsion.publish.R$string;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.ui.ClippingImageActivity;
import com.transsion.publish.ui.GalleryActivity;
import ej.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* loaded from: classes6.dex */
public final class e0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    private final Function1 f50399a;

    /* renamed from: b, reason: collision with root package name */
    private List f50400b;

    /* renamed from: c, reason: collision with root package name */
    private FrameLayout.LayoutParams f50401c;

    /* renamed from: d, reason: collision with root package name */
    private int f50402d;

    /* renamed from: e, reason: collision with root package name */
    private List f50403e;

    /* renamed from: f, reason: collision with root package name */
    private int f50404f;

    /* renamed from: g, reason: collision with root package name */
    private int f50405g;

    /* renamed from: h, reason: collision with root package name */
    private Activity f50406h;

    /* renamed from: i, reason: collision with root package name */
    private int f50407i;

    /* loaded from: classes6.dex */
    public static final class a implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ PhotoEntity f50409b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ f0 f50410c;

        a(PhotoEntity photoEntity, f0 f0Var) {
            this.f50409b = photoEntity;
            this.f50410c = f0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e0 e0Var;
            Activity activity;
            if (com.transsion.baseui.util.c.f43558a.a(view != null ? view.getId() : 0, 500L)) {
                return;
            }
            if (e0.this.f50405g == 5 || e0.this.f50405g == 7) {
                String localPath = this.f50409b.getLocalPath();
                if (localPath == null || (activity = (e0Var = e0.this).f50406h) == null) {
                    return;
                }
                ClippingImageActivity.Companion.b(ClippingImageActivity.INSTANCE, activity, localPath, e0Var.f50405g, null, 8, null);
                return;
            }
            if (e0.this.t()) {
                e0.this.s(this.f50409b, this.f50410c, true);
            } else if (this.f50409b.getEnableSelect()) {
                e0.this.s(this.f50409b, this.f50410c, true);
            } else {
                e0.this.m(this.f50409b, this.f50410c);
            }
        }
    }

    public e0(Function1 selectItem) {
        Intrinsics.h(selectItem, "selectItem");
        this.f50399a = selectItem;
        this.f50400b = new ArrayList();
        this.f50403e = new ArrayList();
        this.f50404f = 9;
        this.f50407i = Task.EXTRAS_LIMIT_BYTES;
        this.f50402d = (com.blankj.utilcode.util.y.b() - (com.blankj.utilcode.util.a0.a(3.0f) * 5)) / 4;
        int i11 = this.f50402d;
        this.f50401c = new FrameLayout.LayoutParams(i11, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(PhotoEntity photoEntity, f0 f0Var) {
        o(photoEntity);
        this.f50403e.add(photoEntity);
        this.f50399a.invoke(Integer.valueOf(this.f50403e.size()));
        photoEntity.setEnableSelect(true);
        f0Var.h().setText(p(photoEntity));
        f0Var.h().setBackgroundResource(R$drawable.bg_linear_r16);
        if (t()) {
            notifyDataSetChanged();
        }
    }

    private final void o(PhotoEntity photoEntity) {
        PhotoEntity photoEntity2 = null;
        for (PhotoEntity photoEntity3 : this.f50403e) {
            if (TextUtils.equals(photoEntity3.getLocalPath(), photoEntity.getLocalPath())) {
                photoEntity2 = photoEntity3;
            }
        }
        if (this.f50403e.contains(photoEntity)) {
            this.f50403e.remove(photoEntity);
        }
        if (photoEntity2 != null) {
            this.f50403e.remove(photoEntity2);
        }
    }

    private final String p(PhotoEntity photoEntity) {
        int i11 = 0;
        for (Object obj : this.f50403e) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.u();
            }
            if (Intrinsics.c(photoEntity.getLocalPath(), ((PhotoEntity) obj).getLocalPath())) {
                return String.valueOf(i12);
            }
            i11 = i12;
        }
        return TmcConstants.COLD_OPEN_TYPE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(PhotoEntity photoEntity, f0 f0Var, boolean z10) {
        if (photoEntity.getEnableSelect()) {
            o(photoEntity);
            this.f50399a.invoke(Integer.valueOf(this.f50403e.size()));
            photoEntity.setEnableSelect(false);
            f0Var.h().setText("");
            f0Var.h().setBackgroundResource(R$drawable.ic_select_number_bro);
            if (z10) {
                notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean t() {
        return this.f50403e.size() >= this.f50404f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(f0 f0Var, e0 e0Var, PhotoEntity photoEntity, int i11, View view) {
        Activity activity;
        String str;
        if (f0Var.i().getVisibility() == 0) {
            Activity activity2 = e0Var.f50406h;
            if (activity2 == null || (str = activity2.getString(R$string.add_img_max_tips)) == null) {
                str = "";
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
            String format = String.format(str, Arrays.copyOf(new Object[]{Integer.valueOf(e0Var.f50404f)}, 1));
            Intrinsics.g(format, "format(...)");
            com.tn.lib.widget.toast.core.h.f41533a.l(format);
            return;
        }
        int i12 = e0Var.f50405g;
        if (i12 != 5 && i12 != 7) {
            com.transsion.publish.n.f50509b.a().f(e0Var.f50400b);
            GalleryActivity.Companion companion = GalleryActivity.INSTANCE;
            Context context = f0Var.itemView.getContext();
            Intrinsics.g(context, "getContext(...)");
            companion.a(context, e0Var.f50403e, i11, 1, e0Var.f50404f);
            return;
        }
        if (photoEntity.getImageSize() > e0Var.f50407i) {
            uh.b.f76876a.e(Utils.a().getResources().getString(R$string.add_media_max_size_tips, 10));
            return;
        }
        String localPath = photoEntity.getLocalPath();
        if (localPath == null || (activity = e0Var.f50406h) == null) {
            return;
        }
        ClippingImageActivity.Companion.b(ClippingImageActivity.INSTANCE, activity, localPath, e0Var.f50405g, null, 8, null);
    }

    public final void A(PhotoEntity photoEntity) {
        if (photoEntity == null || this.f50403e.contains(photoEntity)) {
            return;
        }
        this.f50403e.add(photoEntity);
    }

    public final void addData(List data) {
        Intrinsics.h(data, "data");
        int size = this.f50400b.size();
        this.f50400b.addAll(data);
        notifyItemRangeInserted(size, data.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f50400b.size();
    }

    public final void n() {
        List list = this.f50403e;
        if (list != null) {
            list.clear();
        }
    }

    public final List q() {
        return this.f50400b;
    }

    public final List r() {
        return this.f50403e;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final f0 holder, final int i11) {
        Intrinsics.h(holder, "holder");
        final PhotoEntity photoEntity = (PhotoEntity) this.f50400b.get(i11);
        holder.itemView.setLayoutParams(this.f50401c);
        if (TextUtils.isEmpty(photoEntity.getThumbPath())) {
            String localPath = photoEntity.getLocalPath();
            if (localPath != null && localPath.length() > 0) {
                File file = new File(photoEntity.getLocalPath());
                f.a aVar = ej.f.f62005a;
                Context context = holder.f().getContext();
                Intrinsics.g(context, "getContext(...)");
                aVar.m(context).g(Uri.fromFile(file).toString()).i(R$mipmap.home_ic_default_res).j(0).m(this.f50402d).c(this.f50402d).d(holder.f());
            }
        } else {
            File file2 = new File(photoEntity.getThumbPath());
            f.a aVar2 = ej.f.f62005a;
            Context context2 = holder.f().getContext();
            Intrinsics.g(context2, "getContext(...)");
            aVar2.m(context2).g(Uri.fromFile(file2).toString()).i(R$mipmap.home_ic_default_res).j(0).m(this.f50402d).c(this.f50402d).d(holder.f());
        }
        if (this.f50405g != 0) {
            holder.i().setVisibility(8);
            holder.h().setBackgroundResource(0);
        } else if (!t()) {
            holder.i().setVisibility(8);
            if (photoEntity.getEnableSelect()) {
                holder.h().setText(p(photoEntity));
                holder.h().setBackgroundResource(R$drawable.bg_linear_r16);
            } else {
                holder.h().setText("");
                holder.h().setBackgroundResource(R$drawable.ic_select_number_bro);
            }
        } else if (photoEntity.getEnableSelect()) {
            holder.i().setVisibility(8);
            holder.h().setText(p(photoEntity));
            holder.h().setBackgroundResource(R$drawable.bg_linear_r16);
        } else {
            holder.i().setVisibility(0);
            holder.h().setText("");
            holder.h().setBackgroundResource(R$drawable.ic_select_number_bro);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e0.v(f0.this, this, photoEntity, i11, view);
            }
        });
        holder.g().setOnClickListener(new a(photoEntity, holder));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public f0 onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_select_image, (ViewGroup) null);
        Intrinsics.e(inflate);
        return new f0(inflate);
    }

    public final void x() {
        List list = this.f50400b;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((PhotoEntity) it.next()).setEnableSelect(false);
            }
        }
    }

    public final void y(int i11, Activity activity) {
        Intrinsics.h(activity, "activity");
        this.f50405g = i11;
        this.f50406h = activity;
    }

    public final void z(int i11) {
        this.f50404f = i11;
    }
}
