package com.transsion.publish.adapter;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.transsion.baseui.R$mipmap;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$layout;
import com.transsion.publish.R$string;
import com.transsion.publish.api.VsMediaInfo;
import com.transsion.publish.ui.VideoPreviewActivity;
import ej.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;

/* loaded from: classes6.dex */
public final class k0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    private final Function1 f50446a;

    /* renamed from: b, reason: collision with root package name */
    private List f50447b;

    /* renamed from: c, reason: collision with root package name */
    private FrameLayout.LayoutParams f50448c;

    /* renamed from: d, reason: collision with root package name */
    private List f50449d;

    /* renamed from: e, reason: collision with root package name */
    private int f50450e;

    /* renamed from: f, reason: collision with root package name */
    private int f50451f;

    /* renamed from: g, reason: collision with root package name */
    private int f50452g;

    /* renamed from: h, reason: collision with root package name */
    private int f50453h;

    public k0(Function1 selectItem) {
        Intrinsics.h(selectItem, "selectItem");
        this.f50446a = selectItem;
        this.f50447b = new ArrayList();
        this.f50449d = new ArrayList();
        this.f50450e = 1;
        this.f50451f = 52428800;
        this.f50452g = 1200000;
        this.f50453h = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
        int b11 = (com.blankj.utilcode.util.y.b() - (com.blankj.utilcode.util.a0.a(3.0f) * 5)) / 4;
        this.f50448c = new FrameLayout.LayoutParams(b11, b11);
    }

    private final void k(m0 m0Var, Function0 function0) {
        if (!n() || m0Var.g().getVisibility() != 0) {
            function0.invoke();
            return;
        }
        String string = Utils.a().getString(R$string.add_video_max_tips);
        Intrinsics.g(string, "getString(...)");
        StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.f50450e)}, 1));
        Intrinsics.g(format, "format(...)");
        com.tn.lib.widget.toast.core.h.f41533a.l(format);
    }

    private final String l(VsMediaInfo vsMediaInfo) {
        int i11 = 0;
        for (Object obj : this.f50449d) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.u();
            }
            if (Intrinsics.c(vsMediaInfo.getVideoPath(), ((VsMediaInfo) obj).getVideoPath())) {
                return String.valueOf(i12);
            }
            i11 = i12;
        }
        return TmcConstants.COLD_OPEN_TYPE;
    }

    private final boolean n() {
        return this.f50449d.size() >= this.f50450e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(boolean z10, boolean z11, boolean z12, k0 k0Var, final m0 m0Var, final VsMediaInfo vsMediaInfo, View it) {
        Intrinsics.h(it, "it");
        if (z10) {
            uh.b.f76876a.e("Exceeded video length, 20 mins Max");
            return Unit.f67184a;
        }
        if (z11) {
            uh.b.f76876a.e(Utils.a().getResources().getString(R$string.add_media_max_size_tips, 50));
            return Unit.f67184a;
        }
        if (z12) {
            uh.b.f76876a.e("video requires at least 3s");
            return Unit.f67184a;
        }
        k0Var.k(m0Var, new Function0() { // from class: com.transsion.publish.adapter.j0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit r11;
                r11 = k0.r(m0.this, vsMediaInfo);
                return r11;
            }
        });
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(m0 m0Var, VsMediaInfo vsMediaInfo) {
        VideoPreviewActivity.Companion companion = VideoPreviewActivity.INSTANCE;
        Context context = m0Var.itemView.getContext();
        Intrinsics.g(context, "getContext(...)");
        companion.a(context, vsMediaInfo, 2);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(boolean z10, boolean z11, boolean z12, final k0 k0Var, m0 m0Var, final VsMediaInfo vsMediaInfo, View it) {
        Intrinsics.h(it, "it");
        if (z10) {
            uh.b.f76876a.e("Exceeded video length, 20 mins Max");
            return Unit.f67184a;
        }
        if (z11) {
            uh.b.f76876a.e(Utils.a().getResources().getString(R$string.add_media_max_size_tips, 50));
            return Unit.f67184a;
        }
        if (z12) {
            uh.b.f76876a.e("video requires at least 3s");
            return Unit.f67184a;
        }
        k0Var.k(m0Var, new Function0() { // from class: com.transsion.publish.adapter.i0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit t11;
                t11 = k0.t(VsMediaInfo.this, k0Var);
                return t11;
            }
        });
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(VsMediaInfo vsMediaInfo, k0 k0Var) {
        if (vsMediaInfo.getEnableSelect()) {
            k0Var.z(vsMediaInfo);
        } else {
            k0Var.y(vsMediaInfo);
        }
        return Unit.f67184a;
    }

    private final void v(TextView textView, long j11) {
        if (j11 == 0) {
            return;
        }
        if (2001 <= j11 && j11 < 3000) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
            String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{0, 2}, 2));
            Intrinsics.g(format, "format(...)");
            String format2 = String.format(format, Arrays.copyOf(new Object[0], 0));
            Intrinsics.g(format2, "format(...)");
            textView.setText(format2);
            return;
        }
        if (4001 <= j11 && j11 < 5000) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.f67412a;
            String format3 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{0, 4}, 2));
            Intrinsics.g(format3, "format(...)");
            String format4 = String.format(format3, Arrays.copyOf(new Object[0], 0));
            Intrinsics.g(format4, "format(...)");
            textView.setText(format4);
            return;
        }
        int d11 = MathKt.d(((float) j11) / 1000);
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.f67412a;
        String format5 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(d11 / 60), Integer.valueOf(d11 % 60)}, 2));
        Intrinsics.g(format5, "format(...)");
        String format6 = String.format(format5, Arrays.copyOf(new Object[0], 0));
        Intrinsics.g(format6, "format(...)");
        textView.setText(format6);
    }

    private final void w(VsMediaInfo vsMediaInfo) {
        VsMediaInfo vsMediaInfo2 = null;
        for (VsMediaInfo vsMediaInfo3 : this.f50449d) {
            if (TextUtils.equals(vsMediaInfo3.getVideoPath(), vsMediaInfo.getVideoPath())) {
                vsMediaInfo2 = vsMediaInfo3;
            }
        }
        if (this.f50449d.contains(vsMediaInfo)) {
            this.f50449d.remove(vsMediaInfo);
        }
        if (vsMediaInfo2 != null) {
            this.f50449d.remove(vsMediaInfo2);
        }
    }

    private final void y(VsMediaInfo vsMediaInfo) {
        w(vsMediaInfo);
        this.f50449d.add(vsMediaInfo);
        this.f50446a.invoke(Integer.valueOf(this.f50449d.size()));
        vsMediaInfo.setEnableSelect(true);
        int indexOf = this.f50447b.indexOf(vsMediaInfo);
        if (indexOf >= 0) {
            notifyItemChanged(indexOf, Boolean.TRUE);
        }
        if (n()) {
            notifyDataSetChanged();
        }
    }

    private final void z(VsMediaInfo vsMediaInfo) {
        boolean n11 = n();
        w(vsMediaInfo);
        this.f50446a.invoke(Integer.valueOf(this.f50449d.size()));
        vsMediaInfo.setEnableSelect(false);
        int indexOf = this.f50447b.indexOf(vsMediaInfo);
        if (indexOf >= 0) {
            notifyItemChanged(indexOf, Boolean.FALSE);
        }
        if (n11) {
            notifyDataSetChanged();
        }
    }

    public final void addData(List data) {
        Intrinsics.h(data, "data");
        int size = this.f50447b.size();
        this.f50447b.addAll(data);
        notifyItemRangeInserted(size, data.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f50447b.size();
    }

    public final List m() {
        return this.f50449d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final m0 holder, int i11) {
        Intrinsics.h(holder, "holder");
        final VsMediaInfo vsMediaInfo = (VsMediaInfo) this.f50447b.get(i11);
        holder.itemView.setLayoutParams(this.f50448c);
        v(holder.i(), vsMediaInfo.getVideoDuration());
        if (TextUtils.isEmpty(vsMediaInfo.getImagePath())) {
            String videoPath = vsMediaInfo.getVideoPath();
            File file = videoPath != null ? new File(videoPath) : null;
            if (file != null) {
                f.a aVar = ej.f.f62005a;
                Context context = holder.f().getContext();
                Intrinsics.g(context, "getContext(...)");
                aVar.m(context).g(Uri.fromFile(file).toString()).i(R$mipmap.home_ic_default_res).d(holder.f());
            }
        } else {
            f.a aVar2 = ej.f.f62005a;
            Context context2 = holder.f().getContext();
            Intrinsics.g(context2, "getContext(...)");
            aVar2.m(context2).g(vsMediaInfo.getImagePath()).i(R$mipmap.home_ic_default_res).d(holder.f());
        }
        boolean z10 = vsMediaInfo.getVideoSize() >= ((long) this.f50451f);
        boolean z11 = vsMediaInfo.getVideoDuration() >= ((long) this.f50452g);
        boolean z12 = vsMediaInfo.getVideoDuration() < ((long) this.f50453h);
        if (!n()) {
            holder.g().setVisibility(8);
            if (vsMediaInfo.getEnableSelect()) {
                holder.j().setText(l(vsMediaInfo));
                holder.j().setBackgroundResource(R$drawable.bg_linear_r16);
            } else {
                holder.j().setText("");
                holder.j().setBackgroundResource(R$drawable.ic_select_number_bro);
            }
        } else if (vsMediaInfo.getEnableSelect()) {
            holder.g().setVisibility(8);
            holder.j().setText(l(vsMediaInfo));
            holder.j().setBackgroundResource(R$drawable.bg_linear_r16);
        } else {
            holder.g().setVisibility(0);
            holder.j().setText("");
            holder.j().setBackgroundResource(R$drawable.ic_select_number_bro);
        }
        if (z10 || z11 || z12) {
            holder.g().setVisibility(0);
        }
        View itemView = holder.itemView;
        Intrinsics.g(itemView, "itemView");
        final boolean z13 = z11;
        final boolean z14 = z10;
        final boolean z15 = z12;
        jg.c.c(itemView, 0L, new Function1() { // from class: com.transsion.publish.adapter.g0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit q11;
                q11 = k0.q(z13, z14, z15, this, holder, vsMediaInfo, (View) obj);
                return q11;
            }
        }, 1, null);
        jg.c.c(holder.h(), 0L, new Function1() { // from class: com.transsion.publish.adapter.h0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit s11;
                s11 = k0.s(z13, z14, z15, this, holder, vsMediaInfo, (View) obj);
                return s11;
            }
        }, 1, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(m0 holder, int i11, List payloads) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(payloads, "payloads");
        if (!(CollectionsKt.k0(payloads) instanceof Boolean)) {
            super.onBindViewHolder(holder, i11, payloads);
            return;
        }
        VsMediaInfo vsMediaInfo = (VsMediaInfo) this.f50447b.get(i11);
        if (vsMediaInfo.getEnableSelect()) {
            holder.j().setText(l(vsMediaInfo));
            holder.j().setBackgroundResource(R$drawable.bg_linear_r16);
        } else {
            holder.j().setText("");
            holder.j().setBackgroundResource(R$drawable.ic_select_number_bro);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public m0 onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.upload_select_video_item, (ViewGroup) null);
        Intrinsics.e(inflate);
        return new m0(inflate);
    }

    public final void x(VsMediaInfo data) {
        Intrinsics.h(data, "data");
        VsMediaInfo vsMediaInfo = data;
        for (VsMediaInfo vsMediaInfo2 : this.f50447b) {
            if (TextUtils.equals(vsMediaInfo2.getVideoPath(), data.getVideoPath())) {
                vsMediaInfo2.setEnableSelect(data.getEnableSelect());
                vsMediaInfo = vsMediaInfo2;
            }
        }
        if (data.getEnableSelect()) {
            y(vsMediaInfo);
        } else {
            z(vsMediaInfo);
        }
        notifyItemRangeChanged(0, this.f50447b.size(), Boolean.TRUE);
    }
}
