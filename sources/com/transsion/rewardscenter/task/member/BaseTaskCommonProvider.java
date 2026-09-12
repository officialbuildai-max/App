package com.transsion.rewardscenter.task.member;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;
import com.transsion.rewardscenter.R$mipmap;
import com.transsion.rewardscenter.R$string;
import com.transsion.rewardscenter.ui.RewardsCenterFragment;
import com.transsion.rewardscenterapi.MemberTaskItem;
import ej.f;
import java.util.HashMap;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class BaseTaskCommonProvider extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final wp.a f51243e;

    /* renamed from: f, reason: collision with root package name */
    private final int f51244f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f51245g;

    public BaseTaskCommonProvider(wp.a config) {
        Intrinsics.h(config, "config");
        this.f51243e = config;
        this.f51244f = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(BaseTaskCommonProvider baseTaskCommonProvider, MemberTaskItem memberTaskItem, View view) {
        if (com.transsion.baseui.util.c.f43558a.a(R$id.member_item_task_button, 2000L)) {
            return;
        }
        if (baseTaskCommonProvider.F(memberTaskItem)) {
            baseTaskCommonProvider.J(memberTaskItem);
        } else {
            Intrinsics.f(view, "null cannot be cast to non-null type android.widget.TextView");
            baseTaskCommonProvider.K((TextView) view, memberTaskItem);
        }
        baseTaskCommonProvider.I(memberTaskItem);
    }

    private final int C() {
        Locale locale = Locale.getDefault();
        Intrinsics.g(locale, "getDefault(...)");
        return TextUtils.getLayoutDirectionFromLocale(locale) == 1 ? GravityCompat.END : GravityCompat.START;
    }

    private final void H(MemberTaskItem memberTaskItem) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "task_browse");
        String taskId = memberTaskItem.getTaskId();
        if (taskId == null) {
            taskId = "";
        }
        hashMap.put("taskId", taskId);
        hashMap.put("taskSubType", String.valueOf(memberTaskItem.getTaskSubType()));
        hashMap.put("rewardType", String.valueOf(memberTaskItem.getRewardType()));
        hashMap.put("rewardAmount", String.valueOf(memberTaskItem.getRewardAmount()));
        hashMap.put("showClaim", String.valueOf(this.f51245g));
        com.transsion.baselib.helper.a.f43316a.a("rewards_center", hashMap);
    }

    private final void I(MemberTaskItem memberTaskItem) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "task_click");
        String taskId = memberTaskItem.getTaskId();
        if (taskId == null) {
            taskId = "";
        }
        hashMap.put("taskId", taskId);
        hashMap.put("taskSubType", String.valueOf(memberTaskItem.getTaskSubType()));
        hashMap.put("rewardType", String.valueOf(memberTaskItem.getRewardType()));
        hashMap.put("rewardAmount", String.valueOf(memberTaskItem.getRewardAmount()));
        hashMap.put("showClaim", String.valueOf(this.f51245g));
        com.transsion.baselib.helper.a.f43316a.b("rewards_center", hashMap);
    }

    private final void J(MemberTaskItem memberTaskItem) {
        RewardsCenterFragment rewardsCenterFragment = (RewardsCenterFragment) this.f51243e.a().get();
        if (rewardsCenterFragment != null) {
            rewardsCenterFragment.showLoading();
        }
        kotlinx.coroutines.k.d(this.f51243e.b(), null, null, new BaseTaskCommonProvider$startClaim$1(memberTaskItem, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final wp.a B() {
        return this.f51243e;
    }

    public String D(MemberTaskItem item) {
        Intrinsics.h(item, "item");
        String title = item.getTitle();
        return title == null ? "" : title;
    }

    public void E(TextView button, MemberTaskItem item) {
        Intrinsics.h(button, "button");
        Intrinsics.h(item, "item");
        this.f51245g = F(item);
        Integer status = item.getStatus();
        if (status != null && status.intValue() == 3) {
            button.setText(k().getString(R$string.claimed));
            button.setEnabled(false);
            button.setAlpha(0.5f);
        } else if (this.f51245g) {
            button.setText(button.getContext().getString(R$string.claim));
            button.setEnabled(true);
            button.setAlpha(1.0f);
        } else {
            button.setText(item.getButtonName());
            button.setEnabled(true);
            button.setAlpha(1.0f);
        }
    }

    public boolean F(MemberTaskItem memberTaskItem) {
        return false;
    }

    public void G() {
    }

    public abstract void K(TextView textView, MemberTaskItem memberTaskItem);

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.item_task_common;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, final MemberTaskItem item) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        ImageView imageView = (ImageView) helper.getView(R$id.icon);
        f.a aVar = ej.f.f62005a;
        Context context = imageView.getContext();
        Intrinsics.g(context, "getContext(...)");
        aVar.m(context).g(item.getIcon()).i(R$mipmap.ic_earn_points).d(imageView);
        int i11 = R$id.member_item_task_points_icon;
        Integer rewardType = item.getRewardType();
        helper.setImageResource(i11, (rewardType != null && rewardType.intValue() == this.f51244f) ? R$mipmap.ic_member_small : R$mipmap.ic_points);
        helper.setText(R$id.member_item_task_points_text, "+" + item.getRewardAmount() + " points");
        TextView textView = (TextView) helper.getView(R$id.member_item_task_title);
        textView.setText(D(item));
        textView.setGravity(C());
        TextView textView2 = (TextView) helper.getView(R$id.member_item_task_button);
        E(textView2, item);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.rewardscenter.task.member.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseTaskCommonProvider.A(BaseTaskCommonProvider.this, item, view);
            }
        });
        H(item);
    }
}
