package um;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.view.c0;
import androidx.view.u;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.member.MemberViewModel;
import com.transsion.member.R$id;
import com.transsion.member.R$layout;
import com.transsion.member.R$mipmap;
import com.transsion.member.R$string;
import com.transsion.member.constants.TaskType;
import com.transsion.member.view.CheckInView;
import com.transsion.memberapi.MemberTaskItem;
import com.transsion.memberapi.MemberTaskItemCheckInInfo;
import com.transsion.memberapi.MemberTaskSubmitCheckInRes;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* loaded from: classes6.dex */
public final class c extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final u f76951e;

    /* renamed from: f, reason: collision with root package name */
    private final MemberViewModel f76952f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f76953g;

    /* loaded from: classes6.dex */
    public static final class a implements CheckInView.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MemberTaskItem f76954a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f76955b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CheckInView f76956c;

        a(MemberTaskItem memberTaskItem, c cVar, CheckInView checkInView) {
            this.f76954a = memberTaskItem;
            this.f76955b = cVar;
            this.f76956c = checkInView;
        }

        @Override // com.transsion.member.view.CheckInView.d
        public void a(CheckInView.b holder, int i11) {
            Intrinsics.h(holder, "holder");
            List<MemberTaskItemCheckInInfo> checkInList = this.f76954a.getCheckInList();
            List<MemberTaskItemCheckInInfo> list = checkInList;
            if (list == null || list.isEmpty()) {
                return;
            }
            ImageView imageView = (ImageView) holder.itemView.findViewById(R$id.tag_iv);
            TextView textView = (TextView) holder.itemView.findViewById(R$id.member_point);
            MemberTaskItemCheckInInfo memberTaskItemCheckInInfo = checkInList.get(i11);
            if (textView != null) {
                textView.setText("+" + memberTaskItemCheckInInfo.getRewardAmount() + (memberTaskItemCheckInInfo.getRewardType() == 1 ? "days" : ""));
            }
            if (holder.f() == 2 || holder.f() == 5) {
                if (memberTaskItemCheckInInfo.isToday() && this.f76955b.f76953g) {
                    View findViewById = holder.itemView.findViewById(R$id.member_check_in_tv);
                    if (findViewById != null) {
                        jg.c.g(findViewById);
                    }
                    View findViewById2 = holder.itemView.findViewById(R$id.member_check_in_pb);
                    if (findViewById2 != null) {
                        jg.c.k(findViewById2);
                    }
                } else {
                    View findViewById3 = holder.itemView.findViewById(R$id.member_check_in_tv);
                    if (findViewById3 != null) {
                        jg.c.k(findViewById3);
                    }
                    View findViewById4 = holder.itemView.findViewById(R$id.member_check_in_pb);
                    if (findViewById4 != null) {
                        jg.c.g(findViewById4);
                    }
                }
            }
            if (imageView != null) {
                imageView.setImageResource(memberTaskItemCheckInInfo.getRewardType() == 1 ? R$mipmap.ic_member_small : R$mipmap.ic_member_points);
            }
            TextView textView2 = (TextView) holder.itemView.findViewById(R$id.member_check_in);
            if (textView2 != null) {
                textView2.setText((holder.f() == 5 || holder.f() == 2) ? this.f76956c.getContext().getString(R$string.member_claim) : this.f76956c.getContext().getString(R$string.member_task_day_tip, Integer.valueOf(i11 + 1)));
            }
        }

        @Override // com.transsion.member.view.CheckInView.d
        public int b(int i11) {
            List<MemberTaskItemCheckInInfo> checkInList = this.f76954a.getCheckInList();
            List<MemberTaskItemCheckInInfo> list = checkInList;
            if (list == null || list.isEmpty()) {
                return 2;
            }
            MemberTaskItemCheckInInfo memberTaskItemCheckInInfo = checkInList.get(i11);
            boolean z10 = i11 == checkInList.size() - 1;
            return !memberTaskItemCheckInInfo.getHasCheckIn() ? memberTaskItemCheckInInfo.isToday() ? z10 ? 5 : 2 : z10 ? 6 : 3 : z10 ? 4 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class b implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f76957a;

        b(Function1 function) {
            Intrinsics.h(function, "function");
            this.f76957a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f76957a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f76957a.invoke(obj);
        }
    }

    public c(u owner, MemberViewModel viewModel) {
        Intrinsics.h(owner, "owner");
        Intrinsics.h(viewModel, "viewModel");
        this.f76951e = owner;
        this.f76952f = viewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(CheckInView checkInView, MemberTaskItem memberTaskItem, c cVar, int i11, int i12) {
        if (i12 == 2 || i12 == 5) {
            if (com.transsion.baseui.util.c.f43558a.a(checkInView.getId(), 2000L)) {
                return Unit.f67184a;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                List<MemberTaskItemCheckInInfo> checkInList = memberTaskItem.getCheckInList();
                List<MemberTaskItemCheckInInfo> list = checkInList;
                if (list != null && !list.isEmpty()) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("event_detail", "task_check_in_item");
                    linkedHashMap.put("index", String.valueOf(i11));
                    Unit unit = Unit.f67184a;
                    cVar.F(memberTaskItem, linkedHashMap);
                    MemberTaskItemCheckInInfo memberTaskItemCheckInInfo = checkInList.get(i11);
                    if (memberTaskItemCheckInInfo.getHasCheckIn() || !memberTaskItemCheckInInfo.isToday()) {
                        checkInView.notifyItemCheckInStateChange(i11);
                    } else {
                        cVar.f76953g = true;
                        checkInView.notifyItemCheckInStateChange(i11);
                        cVar.f76952f.W(i11);
                    }
                }
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(c cVar, MemberTaskItem memberTaskItem, CheckInView checkInView, Pair pair) {
        Object obj;
        if (!cVar.f76953g) {
            return Unit.f67184a;
        }
        cVar.f76953g = false;
        List<MemberTaskItemCheckInInfo> checkInList = memberTaskItem.getCheckInList();
        if (checkInList == null || checkInList.isEmpty()) {
            return Unit.f67184a;
        }
        int intValue = ((Number) pair.getFirst()).intValue();
        MemberTaskSubmitCheckInRes memberTaskSubmitCheckInRes = (MemberTaskSubmitCheckInRes) pair.getSecond();
        if (memberTaskSubmitCheckInRes != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("event_detail", "task_check_in_item_success");
            linkedHashMap.put("index", String.valueOf(intValue));
            Unit unit = Unit.f67184a;
            cVar.F(memberTaskItem, linkedHashMap);
            List<MemberTaskItemCheckInInfo> checkInList2 = memberTaskItem.getCheckInList();
            if (checkInList2 != null) {
                Iterator<T> it = checkInList2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((MemberTaskItemCheckInInfo) obj).isToday()) {
                        break;
                    }
                }
                MemberTaskItemCheckInInfo memberTaskItemCheckInInfo = (MemberTaskItemCheckInInfo) obj;
                if (memberTaskItemCheckInInfo != null) {
                    memberTaskItemCheckInInfo.setHasCheckIn(true);
                }
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
            String string = checkInView.getContext().getString(memberTaskSubmitCheckInRes.getRewardType() == 1 ? R$string.member_claimed_succeed_days : R$string.member_reward_points_receive_tips);
            Intrinsics.g(string, "getString(...)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(memberTaskSubmitCheckInRes.getRewardAmount())}, 1));
            Intrinsics.g(format, "format(...)");
            cVar.G(format);
        } else {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put("event_detail", "task_check_in_item_fail");
            linkedHashMap2.put("index", String.valueOf(intValue));
            Unit unit2 = Unit.f67184a;
            cVar.F(memberTaskItem, linkedHashMap2);
            String string2 = checkInView.getContext().getString(R$string.member_reward_receive_fault_tips);
            Intrinsics.g(string2, "getString(...)");
            cVar.G(string2);
        }
        checkInView.notifyItemCheckInStateChange(intValue);
        return Unit.f67184a;
    }

    private final void E(MemberTaskItem memberTaskItem) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "task_browse");
        hashMap.put("taskSubType", String.valueOf(memberTaskItem.getTaskSubType()));
        hashMap.put("rewardType", String.valueOf(memberTaskItem.getRewardType()));
        hashMap.put("rewardAmount", String.valueOf(memberTaskItem.getRewardAmount()));
        List<MemberTaskItemCheckInInfo> checkInList = memberTaskItem.getCheckInList();
        Object obj = null;
        if (checkInList != null) {
            Iterator<T> it = checkInList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                MemberTaskItemCheckInInfo memberTaskItemCheckInInfo = (MemberTaskItemCheckInInfo) next;
                if (memberTaskItemCheckInInfo.isToday() && !memberTaskItemCheckInInfo.getHasCheckIn()) {
                    obj = next;
                    break;
                }
            }
            obj = (MemberTaskItemCheckInInfo) obj;
        }
        hashMap.put("showClaim", String.valueOf(obj == null));
        com.transsion.baselib.helper.a.f43316a.a("memberdetail", hashMap);
    }

    private final void F(MemberTaskItem memberTaskItem, Map map) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "task_click");
        hashMap.put("taskSubType", String.valueOf(memberTaskItem.getTaskSubType()));
        hashMap.put("rewardType", String.valueOf(memberTaskItem.getRewardType()));
        hashMap.put("rewardAmount", String.valueOf(memberTaskItem.getRewardAmount()));
        List<MemberTaskItemCheckInInfo> checkInList = memberTaskItem.getCheckInList();
        Object obj = null;
        if (checkInList != null) {
            Iterator<T> it = checkInList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                MemberTaskItemCheckInInfo memberTaskItemCheckInInfo = (MemberTaskItemCheckInInfo) next;
                if (memberTaskItemCheckInInfo.isToday() && !memberTaskItemCheckInInfo.getHasCheckIn()) {
                    obj = next;
                    break;
                }
            }
            obj = (MemberTaskItemCheckInInfo) obj;
        }
        hashMap.put("showClaim", String.valueOf(obj == null));
        hashMap.putAll(map);
        com.transsion.baselib.helper.a.f43316a.b("memberdetail", hashMap);
    }

    private final void G(String str) {
        uh.b.f76876a.g(R$layout.claim_succeed_layout, str, (r13 & 4) != 0 ? 0 : 80, (r13 & 8) != 0 ? 0 : 0, (r13 & 16) != 0 ? 0 : a0.a(66.0f));
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, final MemberTaskItem item) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        E(item);
        final CheckInView checkInView = (CheckInView) helper.getView(R$id.member_check_in_view);
        checkInView.setDataViewBinder(new a(item, this, checkInView));
        checkInView.setItemClicker(new Function2() { // from class: um.a
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit C;
                C = c.C(CheckInView.this, item, this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return C;
            }
        });
        checkInView.notifyAllChange();
        this.f76952f.L().j(this.f76951e, new b(new Function1() { // from class: um.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit D;
                D = c.D(c.this, item, checkInView, (Pair) obj);
                return D;
            }
        }));
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return TaskType.CHECK_IN.getValue();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.item_task_check_in_container;
    }
}
