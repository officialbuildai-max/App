package com.transsion.search.widget;

import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.PlayUrl;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.search.bean.GroupInfo;
import com.transsion.search.bean.HotSubject;
import com.transsion.search.bean.SuggestEntity;
import com.transsion.search.bean.VerticalRank;
import com.transsion.search.fragment.BaseSearchMainFragment;
import com.transsion.search.fragment.hot.SearchHotFragment;
import hj.i;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final a f52324a = new a(null);

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Group group, int i11, long j11, String str, String str2, String str3, String sugSource) {
            String groupId;
            Intrinsics.h(sugSource, "sugSource");
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "result_item_browse");
            String str4 = "";
            if (str == null) {
                str = "";
            }
            hashMap.put("keyword", str);
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put("search_from", str2);
            hashMap.put("index", String.valueOf(i11));
            hashMap.put("tabId", String.valueOf(str3));
            hashMap.put("duration", String.valueOf(j11));
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            if (group != null && (groupId = group.getGroupId()) != null) {
                str4 = groupId;
            }
            hashMap.put("group_id", str4);
            hashMap.put("hasJoin", String.valueOf(group != null ? group.getHasJoin() : null));
            hashMap.put("sug_source", sugSource);
            com.transsion.baselib.helper.a.f43316a.e("searchresult", hashMap);
        }

        public final void b(Group group, int i11, String str, String str2, String str3, String sugSource) {
            String groupId;
            Intrinsics.h(sugSource, "sugSource");
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "result_item_click");
            String str4 = "";
            if (str == null) {
                str = "";
            }
            hashMap.put("keyword", str);
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put("search_from", str2);
            hashMap.put("index", String.valueOf(i11));
            hashMap.put("tabId", String.valueOf(str3));
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            if (group != null && (groupId = group.getGroupId()) != null) {
                str4 = groupId;
            }
            hashMap.put("group_id", str4);
            hashMap.put("hasJoin", String.valueOf(group != null ? group.getHasJoin() : null));
            hashMap.put("sug_source", sugSource);
            com.transsion.baselib.helper.a.f43316a.f("searchresult", hashMap);
        }

        public final void c(String sugSource) {
            Intrinsics.h(sugSource, "sugSource");
            com.transsion.baselib.helper.a.f43316a.f(SearchHotFragment.PAGE_NAME, MapsKt.l(TuplesKt.a("event_type", "history_delete"), TuplesKt.a("search_id", BaseSearchMainFragment.INSTANCE.a()), TuplesKt.a("sug_source", sugSource)));
        }

        public final void d(boolean z10, String sugSource) {
            Intrinsics.h(sugSource, "sugSource");
            HashMap hashMap = new HashMap();
            hashMap.put("isExpand", String.valueOf(z10));
            hashMap.put("event_type", "history_expand");
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            hashMap.put("sug_source", sugSource);
            com.transsion.baselib.helper.a.f43316a.f(SearchHotFragment.PAGE_NAME, hashMap);
        }

        public final void e(String str, int i11, String sugSource) {
            Intrinsics.h(sugSource, "sugSource");
            HashMap hashMap = new HashMap();
            if (str == null) {
                str = "";
            }
            hashMap.put("keyword", str);
            hashMap.put("index", String.valueOf(i11));
            hashMap.put("event_type", "history_browse");
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            hashMap.put("sug_source", sugSource);
            com.transsion.baselib.helper.a.f43316a.a(SearchHotFragment.PAGE_NAME, hashMap);
        }

        public final void f(String keyWord, int i11, String sugSource) {
            Intrinsics.h(keyWord, "keyWord");
            Intrinsics.h(sugSource, "sugSource");
            HashMap hashMap = new HashMap();
            hashMap.put("keyword", keyWord);
            hashMap.put("index", String.valueOf(i11));
            hashMap.put("event_type", "history_click");
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            hashMap.put("sug_source", sugSource);
            com.transsion.baselib.helper.a.f43316a.f(SearchHotFragment.PAGE_NAME, hashMap);
        }

        public final void g(String str, int i11, String sugSource) {
            Intrinsics.h(sugSource, "sugSource");
            HashMap hashMap = new HashMap();
            if (str == null) {
                str = "";
            }
            hashMap.put("keyword", str);
            hashMap.put("index", String.valueOf(i11));
            hashMap.put("event_type", "hot_word_browse");
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            hashMap.put("sug_source", sugSource);
            com.transsion.baselib.helper.a.f43316a.e(SearchHotFragment.PAGE_NAME, hashMap);
        }

        public final void h(String keyword, int i11, String sugSource) {
            Intrinsics.h(keyword, "keyword");
            Intrinsics.h(sugSource, "sugSource");
            HashMap hashMap = new HashMap();
            hashMap.put("keyword", keyword);
            hashMap.put("index", String.valueOf(i11));
            hashMap.put("event_type", "hot_word_click");
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            hashMap.put("sug_source", sugSource);
            com.transsion.baselib.helper.a.f43316a.f(SearchHotFragment.PAGE_NAME, hashMap);
        }

        public final void i(String str, String str2, String sugSource) {
            Intrinsics.h(sugSource, "sugSource");
            HashMap hashMap = new HashMap();
            if (str == null) {
                str = "";
            }
            hashMap.put("keyword", str);
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put("search_from", str2);
            hashMap.put("event_type", "result_empty");
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            hashMap.put("sug_source", sugSource);
            com.transsion.baselib.helper.a.f43316a.e("searchresult", hashMap);
        }

        public final void j(VerticalRank verticalRank, int i11, long j11, String str, String str2, String str3, String sugSource) {
            String title;
            Intrinsics.h(sugSource, "sugSource");
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "result_item_browse");
            String str4 = "";
            if (str == null) {
                str = "";
            }
            hashMap.put("keyword", str);
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put("search_from", str2);
            hashMap.put("index", String.valueOf(i11));
            hashMap.put("tabId", String.valueOf(str3));
            hashMap.put("duration", String.valueOf(j11));
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            if (verticalRank != null && (title = verticalRank.getTitle()) != null) {
                str4 = title;
            }
            hashMap.put("rank_title", str4);
            hashMap.put("sug_source", sugSource);
            com.transsion.baselib.helper.a.f43316a.e("searchresult", hashMap);
        }

        public final void k(VerticalRank verticalRank, int i11, String str, String str2, String str3, String sugSource) {
            String title;
            Intrinsics.h(sugSource, "sugSource");
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "result_item_click");
            String str4 = "";
            if (str == null) {
                str = "";
            }
            hashMap.put("keyword", str);
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put("search_from", str2);
            hashMap.put("index", String.valueOf(i11));
            hashMap.put("tabId", String.valueOf(str3));
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            if (verticalRank != null && (title = verticalRank.getTitle()) != null) {
                str4 = title;
            }
            hashMap.put("rank_title", str4);
            hashMap.put("sug_source", sugSource);
            com.transsion.baselib.helper.a.f43316a.f("searchresult", hashMap);
        }

        public final void l(GroupInfo group, int i11, String parentCategory, int i12, boolean z10, String sugSource) {
            Intrinsics.h(group, "group");
            Intrinsics.h(parentCategory, "parentCategory");
            Intrinsics.h(sugSource, "sugSource");
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "hot_rank_browse");
            hashMap.put("group_id", group.getGroupId());
            hashMap.put("ops", group.getOps());
            hashMap.put("index", String.valueOf(i11));
            hashMap.put("lowMemoryDevice", String.valueOf(z10));
            hashMap.put("parentTitle", parentCategory);
            hashMap.put("parentIndex", String.valueOf(i12));
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            hashMap.put("sug_source", sugSource);
            com.transsion.baselib.helper.a.f43316a.a(SearchHotFragment.PAGE_NAME, hashMap);
        }

        public final void m(GroupInfo group, int i11, String parentCategory, int i12, boolean z10, String sugSource) {
            Intrinsics.h(group, "group");
            Intrinsics.h(parentCategory, "parentCategory");
            Intrinsics.h(sugSource, "sugSource");
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "hot_rank_click");
            hashMap.put("group_id", group.getGroupId());
            hashMap.put("index", String.valueOf(i11));
            hashMap.put("ops", group.getOps());
            hashMap.put("lowMemoryDevice", String.valueOf(z10));
            hashMap.put("parentTitle", parentCategory);
            hashMap.put("parentIndex", String.valueOf(i12));
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            hashMap.put("sug_source", sugSource);
            com.transsion.baselib.helper.a.f43316a.f(SearchHotFragment.PAGE_NAME, hashMap);
        }

        public final void n(HotSubject hotSubject, int i11, String parentCategory, int i12, boolean z10, String sugSource) {
            Intrinsics.h(hotSubject, "hotSubject");
            Intrinsics.h(parentCategory, "parentCategory");
            Intrinsics.h(sugSource, "sugSource");
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "hot_rank_browse");
            String subjectId = hotSubject.getSubjectId();
            if (subjectId == null) {
                subjectId = "";
            }
            hashMap.put("subject_id", subjectId);
            hashMap.put("index", String.valueOf(i11));
            hashMap.put("subject_type", String.valueOf(hotSubject.getSubjectType()));
            String ops = hotSubject.getOps();
            hashMap.put("ops", ops != null ? ops : "");
            hashMap.put("lowMemoryDevice", String.valueOf(z10));
            hashMap.put("parentTitle", parentCategory);
            hashMap.put("parentIndex", String.valueOf(i12));
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            hashMap.put("sug_source", sugSource);
            com.transsion.baselib.helper.a.f43316a.a(SearchHotFragment.PAGE_NAME, hashMap);
        }

        public final void o(HotSubject hotSubject, int i11, String parentCategory, int i12, boolean z10, String sugSource) {
            Intrinsics.h(hotSubject, "hotSubject");
            Intrinsics.h(parentCategory, "parentCategory");
            Intrinsics.h(sugSource, "sugSource");
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "hot_rank_click");
            String subjectId = hotSubject.getSubjectId();
            if (subjectId == null) {
                subjectId = "";
            }
            hashMap.put("subject_id", subjectId);
            hashMap.put("index", String.valueOf(i11));
            hashMap.put("subject_type", String.valueOf(hotSubject.getSubjectType()));
            String ops = hotSubject.getOps();
            hashMap.put("ops", ops != null ? ops : "");
            hashMap.put("lowMemoryDevice", String.valueOf(z10));
            hashMap.put("parentTitle", parentCategory);
            hashMap.put("parentIndex", String.valueOf(i12));
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            hashMap.put("sug_source", sugSource);
            com.transsion.baselib.helper.a.f43316a.f(SearchHotFragment.PAGE_NAME, hashMap);
        }

        public final void p(String str, String str2, long j11, int i11, String sugSource) {
            Intrinsics.h(sugSource, "sugSource");
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "result_scroll_skip");
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put("keyword", str2);
            hashMap.put("tabId", String.valueOf(str));
            hashMap.put("skip_item", String.valueOf(j11));
            hashMap.put("fromIndex", String.valueOf(i11));
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            hashMap.put("sug_source", sugSource);
            com.transsion.baselib.helper.a.f43316a.f("searchresult", hashMap);
        }

        public final void q(String keyword, String str, String sugSource) {
            Intrinsics.h(keyword, "keyword");
            Intrinsics.h(sugSource, "sugSource");
            if (str == null) {
                str = "";
            }
            com.transsion.baselib.helper.a.f43316a.b("searchresult", MapsKt.l(TuplesKt.a("search_from", str), TuplesKt.a("keyword", keyword), TuplesKt.a("event_type", "search"), TuplesKt.a("search_id", BaseSearchMainFragment.INSTANCE.a()), TuplesKt.a("sug_source", sugSource)));
        }

        public final void r(Staff staff, int i11, long j11, String str, String str2, String str3, String sugSource) {
            String str4;
            String ops;
            Intrinsics.h(sugSource, "sugSource");
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "result_item_browse");
            String str5 = "";
            if (str == null) {
                str = "";
            }
            hashMap.put("keyword", str);
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put("search_from", str2);
            hashMap.put("index", String.valueOf(i11));
            hashMap.put("tabId", String.valueOf(str3));
            hashMap.put("duration", String.valueOf(j11));
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            if (staff == null || (str4 = staff.getStaffId()) == null) {
                str4 = "";
            }
            hashMap.put("staff_id", str4);
            if (staff != null && (ops = staff.getOps()) != null) {
                str5 = ops;
            }
            hashMap.put("ops", str5);
            hashMap.put("sug_source", sugSource);
            com.transsion.baselib.helper.a.f43316a.e("searchresult", hashMap);
        }

        public final void s(Staff staff, int i11, String str, String str2, String str3, String sugSource) {
            String str4;
            String ops;
            Intrinsics.h(sugSource, "sugSource");
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "result_item_click");
            String str5 = "";
            if (str == null) {
                str = "";
            }
            hashMap.put("keyword", str);
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put("search_from", str2);
            hashMap.put("index", String.valueOf(i11));
            hashMap.put("tabId", String.valueOf(str3));
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            if (staff == null || (str4 = staff.getStaffId()) == null) {
                str4 = "";
            }
            hashMap.put("staff_id", str4);
            if (staff != null && (ops = staff.getOps()) != null) {
                str5 = ops;
            }
            hashMap.put("ops", str5);
            hashMap.put("sug_source", sugSource);
            com.transsion.baselib.helper.a.f43316a.f("searchresult", hashMap);
        }

        public final void t(Subject subject, int i11, long j11, String str, String str2, String str3, String sugSource) {
            String str4;
            String str5;
            String num;
            Intrinsics.h(sugSource, "sugSource");
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "result_item_browse");
            String str6 = "";
            if (str == null) {
                str = "";
            }
            hashMap.put("keyword", str);
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put("search_from", str2);
            hashMap.put("index", String.valueOf(i11));
            hashMap.put("tabId", String.valueOf(str3));
            hashMap.put("duration", String.valueOf(j11));
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            if (subject == null || (str4 = subject.getSubjectId()) == null) {
                str4 = "";
            }
            hashMap.put("subject_id", str4);
            hashMap.put("subject_type", String.valueOf(subject != null ? subject.getSubjectType() : null));
            if (subject == null || (str5 = subject.getOps()) == null) {
                str5 = "";
            }
            hashMap.put("ops", str5);
            if (subject != null && (num = Integer.valueOf(subject.getSeason()).toString()) != null) {
                str6 = num;
            }
            hashMap.put("season", str6);
            hashMap.put("sug_source", sugSource);
            com.transsion.baselib.helper.a.f43316a.e("searchresult", hashMap);
        }

        public final void u(Subject subject, int i11, String str, String str2, String str3, String sugSource) {
            String str4;
            String str5;
            String str6;
            String num;
            PlayUrl playUrl;
            PlayUrl playUrl2;
            Intrinsics.h(sugSource, "sugSource");
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "result_item_click");
            String str7 = "";
            if (str == null) {
                str = "";
            }
            hashMap.put("keyword", str);
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put("search_from", str2);
            hashMap.put("index", String.valueOf(i11));
            hashMap.put("tabId", String.valueOf(str3));
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            if (subject == null || (str4 = subject.getSubjectId()) == null) {
                str4 = "";
            }
            hashMap.put("subject_id", str4);
            String str8 = null;
            hashMap.put("subject_type", String.valueOf(subject != null ? subject.getSubjectType() : null));
            if (subject == null || (str5 = subject.getOps()) == null) {
                str5 = "";
            }
            hashMap.put("ops", str5);
            String playUrl3 = (subject == null || (playUrl2 = subject.getPlayUrl()) == null) ? null : playUrl2.getPlayUrl();
            if (playUrl3 == null || playUrl3.length() == 0) {
                str6 = "NOT_URL";
            } else {
                if (subject != null && (playUrl = subject.getPlayUrl()) != null) {
                    str8 = playUrl.getUrlType();
                }
                str6 = String.valueOf(str8);
            }
            hashMap.put("jump_type", str6);
            if (subject != null && (num = Integer.valueOf(subject.getSeason()).toString()) != null) {
                str7 = num;
            }
            hashMap.put("season", str7);
            hashMap.put("sug_source", sugSource);
            com.transsion.baselib.helper.a.f43316a.f("searchresult", hashMap);
        }

        public final void v(SuggestEntity suggestEntity, Integer num, String keyWord, String str, String sugSource) {
            String str2;
            String str3;
            VerticalRank verticalRank;
            String title;
            Subject subject;
            Intrinsics.h(keyWord, "keyWord");
            Intrinsics.h(sugSource, "sugSource");
            try {
                Result.Companion companion = Result.INSTANCE;
                HashMap hashMap = new HashMap();
                hashMap.put(NativeComponentConstants.KEY_COMPONENT_TYPE, String.valueOf(suggestEntity != null ? suggestEntity.getType() : null));
                hashMap.put(MBridgeConstans.KEY_WORD, keyWord);
                String str4 = "";
                if (str == null) {
                    str = "";
                }
                hashMap.put("ops", str);
                if (suggestEntity == null || (str2 = suggestEntity.getWord()) == null) {
                    str2 = "";
                }
                hashMap.put(CampaignEx.JSON_KEY_TITLE, str2);
                if (suggestEntity == null || (subject = suggestEntity.getSubject()) == null || (str3 = subject.getSubjectId()) == null) {
                    str3 = "";
                }
                hashMap.put("subject_id", str3);
                if (suggestEntity != null && (verticalRank = suggestEntity.getVerticalRank()) != null && (title = verticalRank.getTitle()) != null) {
                    str4 = title;
                }
                hashMap.put("word", str4);
                hashMap.put("index", String.valueOf(num));
                hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
                hashMap.put("sug_source", sugSource);
                i.f64628a.D("search_suggest", hashMap);
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }

        public final void w(SuggestEntity suggestEntity, int i11, String keyWord, String str, String sugSource) {
            String str2;
            String str3;
            String str4;
            Staff staff;
            String staffId;
            VerticalRank verticalRank;
            Subject subject;
            Intrinsics.h(keyWord, "keyWord");
            Intrinsics.h(sugSource, "sugSource");
            try {
                Result.Companion companion = Result.INSTANCE;
                HashMap hashMap = new HashMap();
                hashMap.put(NativeComponentConstants.KEY_COMPONENT_TYPE, String.valueOf(suggestEntity != null ? suggestEntity.getType() : null));
                hashMap.put(MBridgeConstans.KEY_WORD, keyWord);
                String str5 = "";
                if (str == null) {
                    str = "";
                }
                hashMap.put("ops", str);
                if (suggestEntity == null || (str2 = suggestEntity.getWord()) == null) {
                    str2 = "";
                }
                hashMap.put(CampaignEx.JSON_KEY_TITLE, str2);
                if (suggestEntity == null || (subject = suggestEntity.getSubject()) == null || (str3 = subject.getSubjectId()) == null) {
                    str3 = "";
                }
                hashMap.put("subject_id", str3);
                if (suggestEntity == null || (verticalRank = suggestEntity.getVerticalRank()) == null || (str4 = verticalRank.getTitle()) == null) {
                    str4 = "";
                }
                hashMap.put("word", str4);
                if (suggestEntity != null && (staff = suggestEntity.getStaff()) != null && (staffId = staff.getStaffId()) != null) {
                    str5 = staffId;
                }
                hashMap.put("staff_id", str5);
                hashMap.put("index", String.valueOf(i11));
                hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
                hashMap.put("sug_source", sugSource);
                i.f64628a.p("search_suggest", hashMap);
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }

        public final void x(String str, String str2, String sugSource) {
            Intrinsics.h(sugSource, "sugSource");
            HashMap hashMap = new HashMap();
            if (str == null) {
                str = "";
            }
            hashMap.put("keyword", str);
            hashMap.put("tabId", String.valueOf(str2));
            hashMap.put("event_type", "result_tab_click");
            hashMap.put("search_id", BaseSearchMainFragment.INSTANCE.a());
            hashMap.put("sug_source", sugSource);
            com.transsion.baselib.helper.a.f43316a.f("searchresult", hashMap);
        }
    }
}
