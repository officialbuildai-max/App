package li;

import androidx.room.RoomDatabase;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.transsion.ad.db.plan.MbAdDbPlans;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes6.dex */
public final class m implements li.b {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f68983a;

    /* renamed from: c, reason: collision with root package name */
    private final li.a f68985c = new li.a();

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f68984b = new a();

    /* renamed from: d, reason: collision with root package name */
    private final androidx.room.e f68986d = new b();

    /* loaded from: classes6.dex */
    class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `mb_ad_db_plans` (`id`,`version`,`name`,`startTime`,`endTime`,`extraConfig`,`displayTimes`,`showedTimes`,`showDate`,`advertiserName`,`advertiserAvatar`,`advertiserAvatarPath`,`brand`,`denyBrand`,`model`,`denyModel`,`country`,`scenes`,`adSource`,`extAdSlot`,`adMaterialList`,`adPlanUpdateTime`,`sort`,`adShowLevel`,`filterClientVersion`,`adPlanCreateTime`,`appStarDesc`,`appSizeDesc`,`ctxEnableExpr`,`ctxDisableExpr`,`ctxAttributeConfig`,`dispatchTimeStart`,`dispatchTimeEnd`,`extImage`,`bidEcpmCent`,`ecpmCent`,`isValid`,`h5LinkPreload`,`h5LinkOpenByCct`,`countryCode`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, MbAdDbPlans mbAdDbPlans) {
            if (mbAdDbPlans.getId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, mbAdDbPlans.getId());
            }
            if (mbAdDbPlans.getVersion() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, mbAdDbPlans.getVersion());
            }
            if (mbAdDbPlans.getName() == null) {
                eVar.g(3);
            } else {
                eVar.j(3, mbAdDbPlans.getName());
            }
            if (mbAdDbPlans.getStartTime() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, mbAdDbPlans.getStartTime());
            }
            if (mbAdDbPlans.getEndTime() == null) {
                eVar.g(5);
            } else {
                eVar.j(5, mbAdDbPlans.getEndTime());
            }
            if (mbAdDbPlans.getExtraConfig() == null) {
                eVar.g(6);
            } else {
                eVar.j(6, mbAdDbPlans.getExtraConfig());
            }
            if (mbAdDbPlans.getDisplayTimes() == null) {
                eVar.g(7);
            } else {
                eVar.c(7, mbAdDbPlans.getDisplayTimes().intValue());
            }
            if (mbAdDbPlans.getShowedTimes() == null) {
                eVar.g(8);
            } else {
                eVar.c(8, mbAdDbPlans.getShowedTimes().intValue());
            }
            if (mbAdDbPlans.getShowDate() == null) {
                eVar.g(9);
            } else {
                eVar.j(9, mbAdDbPlans.getShowDate());
            }
            if (mbAdDbPlans.getAdvertiserName() == null) {
                eVar.g(10);
            } else {
                eVar.j(10, mbAdDbPlans.getAdvertiserName());
            }
            if (mbAdDbPlans.getAdvertiserAvatar() == null) {
                eVar.g(11);
            } else {
                eVar.j(11, mbAdDbPlans.getAdvertiserAvatar());
            }
            if (mbAdDbPlans.getAdvertiserAvatarPath() == null) {
                eVar.g(12);
            } else {
                eVar.j(12, mbAdDbPlans.getAdvertiserAvatarPath());
            }
            String a11 = m.this.f68985c.a(mbAdDbPlans.getBrand());
            if (a11 == null) {
                eVar.g(13);
            } else {
                eVar.j(13, a11);
            }
            String a12 = m.this.f68985c.a(mbAdDbPlans.getDenyBrand());
            if (a12 == null) {
                eVar.g(14);
            } else {
                eVar.j(14, a12);
            }
            String a13 = m.this.f68985c.a(mbAdDbPlans.getModel());
            if (a13 == null) {
                eVar.g(15);
            } else {
                eVar.j(15, a13);
            }
            String a14 = m.this.f68985c.a(mbAdDbPlans.getDenyModel());
            if (a14 == null) {
                eVar.g(16);
            } else {
                eVar.j(16, a14);
            }
            String a15 = m.this.f68985c.a(mbAdDbPlans.getCountry());
            if (a15 == null) {
                eVar.g(17);
            } else {
                eVar.j(17, a15);
            }
            String a16 = m.this.f68985c.a(mbAdDbPlans.getScenes());
            if (a16 == null) {
                eVar.g(18);
            } else {
                eVar.j(18, a16);
            }
            if (mbAdDbPlans.getAdSource() == null) {
                eVar.g(19);
            } else {
                eVar.j(19, mbAdDbPlans.getAdSource());
            }
            if (mbAdDbPlans.getExtAdSlot() == null) {
                eVar.g(20);
            } else {
                eVar.j(20, mbAdDbPlans.getExtAdSlot());
            }
            if (mbAdDbPlans.getAdMaterialList() == null) {
                eVar.g(21);
            } else {
                eVar.j(21, mbAdDbPlans.getAdMaterialList());
            }
            if (mbAdDbPlans.getAdPlanUpdateTime() == null) {
                eVar.g(22);
            } else {
                eVar.j(22, mbAdDbPlans.getAdPlanUpdateTime());
            }
            if (mbAdDbPlans.getSort() == null) {
                eVar.g(23);
            } else {
                eVar.c(23, mbAdDbPlans.getSort().intValue());
            }
            if (mbAdDbPlans.getAdShowLevel() == null) {
                eVar.g(24);
            } else {
                eVar.j(24, mbAdDbPlans.getAdShowLevel());
            }
            if (mbAdDbPlans.getFilterClientVersion() == null) {
                eVar.g(25);
            } else {
                eVar.j(25, mbAdDbPlans.getFilterClientVersion());
            }
            if (mbAdDbPlans.getAdPlanCreateTime() == null) {
                eVar.g(26);
            } else {
                eVar.j(26, mbAdDbPlans.getAdPlanCreateTime());
            }
            if (mbAdDbPlans.getAppStarDesc() == null) {
                eVar.g(27);
            } else {
                eVar.j(27, mbAdDbPlans.getAppStarDesc());
            }
            if (mbAdDbPlans.getAppSizeDesc() == null) {
                eVar.g(28);
            } else {
                eVar.j(28, mbAdDbPlans.getAppSizeDesc());
            }
            if (mbAdDbPlans.getCtxEnableExpr() == null) {
                eVar.g(29);
            } else {
                eVar.j(29, mbAdDbPlans.getCtxEnableExpr());
            }
            if (mbAdDbPlans.getCtxDisableExpr() == null) {
                eVar.g(30);
            } else {
                eVar.j(30, mbAdDbPlans.getCtxDisableExpr());
            }
            if (mbAdDbPlans.getCtxAttributeConfig() == null) {
                eVar.g(31);
            } else {
                eVar.j(31, mbAdDbPlans.getCtxAttributeConfig());
            }
            if (mbAdDbPlans.getDispatchTimeStart() == null) {
                eVar.g(32);
            } else {
                eVar.j(32, mbAdDbPlans.getDispatchTimeStart());
            }
            if (mbAdDbPlans.getDispatchTimeEnd() == null) {
                eVar.g(33);
            } else {
                eVar.j(33, mbAdDbPlans.getDispatchTimeEnd());
            }
            if (mbAdDbPlans.getExtImage() == null) {
                eVar.g(34);
            } else {
                eVar.j(34, mbAdDbPlans.getExtImage());
            }
            if (mbAdDbPlans.getBidEcpmCent() == null) {
                eVar.g(35);
            } else {
                eVar.a(35, mbAdDbPlans.getBidEcpmCent().doubleValue());
            }
            if (mbAdDbPlans.getEcpmCent() == null) {
                eVar.g(36);
            } else {
                eVar.c(36, mbAdDbPlans.getEcpmCent().longValue());
            }
            eVar.c(37, mbAdDbPlans.isValid() ? 1L : 0L);
            eVar.c(38, mbAdDbPlans.getH5LinkPreload() ? 1L : 0L);
            eVar.c(39, mbAdDbPlans.getH5LinkOpenByCct() ? 1L : 0L);
            if (mbAdDbPlans.getCountryCode() == null) {
                eVar.g(40);
            } else {
                eVar.j(40, mbAdDbPlans.getCountryCode());
            }
        }
    }

    /* loaded from: classes6.dex */
    class b extends androidx.room.e {
        b() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "UPDATE OR ABORT `mb_ad_db_plans` SET `id` = ?,`version` = ?,`name` = ?,`startTime` = ?,`endTime` = ?,`extraConfig` = ?,`displayTimes` = ?,`showedTimes` = ?,`showDate` = ?,`advertiserName` = ?,`advertiserAvatar` = ?,`advertiserAvatarPath` = ?,`brand` = ?,`denyBrand` = ?,`model` = ?,`denyModel` = ?,`country` = ?,`scenes` = ?,`adSource` = ?,`extAdSlot` = ?,`adMaterialList` = ?,`adPlanUpdateTime` = ?,`sort` = ?,`adShowLevel` = ?,`filterClientVersion` = ?,`adPlanCreateTime` = ?,`appStarDesc` = ?,`appSizeDesc` = ?,`ctxEnableExpr` = ?,`ctxDisableExpr` = ?,`ctxAttributeConfig` = ?,`dispatchTimeStart` = ?,`dispatchTimeEnd` = ?,`extImage` = ?,`bidEcpmCent` = ?,`ecpmCent` = ?,`isValid` = ?,`h5LinkPreload` = ?,`h5LinkOpenByCct` = ?,`countryCode` = ? WHERE `id` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, MbAdDbPlans mbAdDbPlans) {
            if (mbAdDbPlans.getId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, mbAdDbPlans.getId());
            }
            if (mbAdDbPlans.getVersion() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, mbAdDbPlans.getVersion());
            }
            if (mbAdDbPlans.getName() == null) {
                eVar.g(3);
            } else {
                eVar.j(3, mbAdDbPlans.getName());
            }
            if (mbAdDbPlans.getStartTime() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, mbAdDbPlans.getStartTime());
            }
            if (mbAdDbPlans.getEndTime() == null) {
                eVar.g(5);
            } else {
                eVar.j(5, mbAdDbPlans.getEndTime());
            }
            if (mbAdDbPlans.getExtraConfig() == null) {
                eVar.g(6);
            } else {
                eVar.j(6, mbAdDbPlans.getExtraConfig());
            }
            if (mbAdDbPlans.getDisplayTimes() == null) {
                eVar.g(7);
            } else {
                eVar.c(7, mbAdDbPlans.getDisplayTimes().intValue());
            }
            if (mbAdDbPlans.getShowedTimes() == null) {
                eVar.g(8);
            } else {
                eVar.c(8, mbAdDbPlans.getShowedTimes().intValue());
            }
            if (mbAdDbPlans.getShowDate() == null) {
                eVar.g(9);
            } else {
                eVar.j(9, mbAdDbPlans.getShowDate());
            }
            if (mbAdDbPlans.getAdvertiserName() == null) {
                eVar.g(10);
            } else {
                eVar.j(10, mbAdDbPlans.getAdvertiserName());
            }
            if (mbAdDbPlans.getAdvertiserAvatar() == null) {
                eVar.g(11);
            } else {
                eVar.j(11, mbAdDbPlans.getAdvertiserAvatar());
            }
            if (mbAdDbPlans.getAdvertiserAvatarPath() == null) {
                eVar.g(12);
            } else {
                eVar.j(12, mbAdDbPlans.getAdvertiserAvatarPath());
            }
            String a11 = m.this.f68985c.a(mbAdDbPlans.getBrand());
            if (a11 == null) {
                eVar.g(13);
            } else {
                eVar.j(13, a11);
            }
            String a12 = m.this.f68985c.a(mbAdDbPlans.getDenyBrand());
            if (a12 == null) {
                eVar.g(14);
            } else {
                eVar.j(14, a12);
            }
            String a13 = m.this.f68985c.a(mbAdDbPlans.getModel());
            if (a13 == null) {
                eVar.g(15);
            } else {
                eVar.j(15, a13);
            }
            String a14 = m.this.f68985c.a(mbAdDbPlans.getDenyModel());
            if (a14 == null) {
                eVar.g(16);
            } else {
                eVar.j(16, a14);
            }
            String a15 = m.this.f68985c.a(mbAdDbPlans.getCountry());
            if (a15 == null) {
                eVar.g(17);
            } else {
                eVar.j(17, a15);
            }
            String a16 = m.this.f68985c.a(mbAdDbPlans.getScenes());
            if (a16 == null) {
                eVar.g(18);
            } else {
                eVar.j(18, a16);
            }
            if (mbAdDbPlans.getAdSource() == null) {
                eVar.g(19);
            } else {
                eVar.j(19, mbAdDbPlans.getAdSource());
            }
            if (mbAdDbPlans.getExtAdSlot() == null) {
                eVar.g(20);
            } else {
                eVar.j(20, mbAdDbPlans.getExtAdSlot());
            }
            if (mbAdDbPlans.getAdMaterialList() == null) {
                eVar.g(21);
            } else {
                eVar.j(21, mbAdDbPlans.getAdMaterialList());
            }
            if (mbAdDbPlans.getAdPlanUpdateTime() == null) {
                eVar.g(22);
            } else {
                eVar.j(22, mbAdDbPlans.getAdPlanUpdateTime());
            }
            if (mbAdDbPlans.getSort() == null) {
                eVar.g(23);
            } else {
                eVar.c(23, mbAdDbPlans.getSort().intValue());
            }
            if (mbAdDbPlans.getAdShowLevel() == null) {
                eVar.g(24);
            } else {
                eVar.j(24, mbAdDbPlans.getAdShowLevel());
            }
            if (mbAdDbPlans.getFilterClientVersion() == null) {
                eVar.g(25);
            } else {
                eVar.j(25, mbAdDbPlans.getFilterClientVersion());
            }
            if (mbAdDbPlans.getAdPlanCreateTime() == null) {
                eVar.g(26);
            } else {
                eVar.j(26, mbAdDbPlans.getAdPlanCreateTime());
            }
            if (mbAdDbPlans.getAppStarDesc() == null) {
                eVar.g(27);
            } else {
                eVar.j(27, mbAdDbPlans.getAppStarDesc());
            }
            if (mbAdDbPlans.getAppSizeDesc() == null) {
                eVar.g(28);
            } else {
                eVar.j(28, mbAdDbPlans.getAppSizeDesc());
            }
            if (mbAdDbPlans.getCtxEnableExpr() == null) {
                eVar.g(29);
            } else {
                eVar.j(29, mbAdDbPlans.getCtxEnableExpr());
            }
            if (mbAdDbPlans.getCtxDisableExpr() == null) {
                eVar.g(30);
            } else {
                eVar.j(30, mbAdDbPlans.getCtxDisableExpr());
            }
            if (mbAdDbPlans.getCtxAttributeConfig() == null) {
                eVar.g(31);
            } else {
                eVar.j(31, mbAdDbPlans.getCtxAttributeConfig());
            }
            if (mbAdDbPlans.getDispatchTimeStart() == null) {
                eVar.g(32);
            } else {
                eVar.j(32, mbAdDbPlans.getDispatchTimeStart());
            }
            if (mbAdDbPlans.getDispatchTimeEnd() == null) {
                eVar.g(33);
            } else {
                eVar.j(33, mbAdDbPlans.getDispatchTimeEnd());
            }
            if (mbAdDbPlans.getExtImage() == null) {
                eVar.g(34);
            } else {
                eVar.j(34, mbAdDbPlans.getExtImage());
            }
            if (mbAdDbPlans.getBidEcpmCent() == null) {
                eVar.g(35);
            } else {
                eVar.a(35, mbAdDbPlans.getBidEcpmCent().doubleValue());
            }
            if (mbAdDbPlans.getEcpmCent() == null) {
                eVar.g(36);
            } else {
                eVar.c(36, mbAdDbPlans.getEcpmCent().longValue());
            }
            eVar.c(37, mbAdDbPlans.isValid() ? 1L : 0L);
            eVar.c(38, mbAdDbPlans.getH5LinkPreload() ? 1L : 0L);
            eVar.c(39, mbAdDbPlans.getH5LinkOpenByCct() ? 1L : 0L);
            if (mbAdDbPlans.getCountryCode() == null) {
                eVar.g(40);
            } else {
                eVar.j(40, mbAdDbPlans.getCountryCode());
            }
            if (mbAdDbPlans.getId() == null) {
                eVar.g(41);
            } else {
                eVar.j(41, mbAdDbPlans.getId());
            }
        }
    }

    public m(RoomDatabase roomDatabase) {
        this.f68983a = roomDatabase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List A(String str, z3.b bVar) {
        int i11;
        int i12;
        Integer valueOf;
        String n02;
        int i13;
        String n03;
        String n04;
        String n05;
        String n06;
        String n07;
        int i14;
        String n08;
        int i15;
        String n09;
        int i16;
        String n010;
        int i17;
        int i18;
        int i19;
        Integer valueOf2;
        int i20;
        String n011;
        int i21;
        String n012;
        int i22;
        int i23;
        String n013;
        int i24;
        String n014;
        int i25;
        String n015;
        int i26;
        String n016;
        int i27;
        String n017;
        int i28;
        String n018;
        int i29;
        String n019;
        int i30;
        String n020;
        int i31;
        String n021;
        int i32;
        Double valueOf3;
        int i33;
        Long valueOf4;
        int i34;
        int i35;
        int i36;
        boolean z10;
        int i37;
        boolean z11;
        int i38;
        boolean z12;
        m mVar = this;
        z3.e D0 = bVar.D0("\n        SELECT * FROM mb_ad_db_plans\n        WHERE isValid = 1\n          AND (\n              scenes IS NULL\n              OR TRIM(scenes) = ''\n              OR TRIM(scenes) = '[]'\n              OR instr(LOWER(scenes), ?) > 0\n          )\n        ORDER BY sort\n        ");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "id");
            int d12 = androidx.room.util.k.d(D0, "version");
            int d13 = androidx.room.util.k.d(D0, "name");
            int d14 = androidx.room.util.k.d(D0, "startTime");
            int d15 = androidx.room.util.k.d(D0, "endTime");
            int d16 = androidx.room.util.k.d(D0, "extraConfig");
            int d17 = androidx.room.util.k.d(D0, "displayTimes");
            int d18 = androidx.room.util.k.d(D0, "showedTimes");
            int d19 = androidx.room.util.k.d(D0, "showDate");
            int d20 = androidx.room.util.k.d(D0, "advertiserName");
            int d21 = androidx.room.util.k.d(D0, "advertiserAvatar");
            int d22 = androidx.room.util.k.d(D0, "advertiserAvatarPath");
            int d23 = androidx.room.util.k.d(D0, "brand");
            int d24 = androidx.room.util.k.d(D0, "denyBrand");
            int d25 = androidx.room.util.k.d(D0, "model");
            int d26 = androidx.room.util.k.d(D0, "denyModel");
            int d27 = androidx.room.util.k.d(D0, PlaceTypes.COUNTRY);
            int d28 = androidx.room.util.k.d(D0, "scenes");
            int d29 = androidx.room.util.k.d(D0, "adSource");
            int d30 = androidx.room.util.k.d(D0, "extAdSlot");
            int d31 = androidx.room.util.k.d(D0, "adMaterialList");
            int d32 = androidx.room.util.k.d(D0, "adPlanUpdateTime");
            int d33 = androidx.room.util.k.d(D0, "sort");
            int d34 = androidx.room.util.k.d(D0, "adShowLevel");
            int d35 = androidx.room.util.k.d(D0, "filterClientVersion");
            int d36 = androidx.room.util.k.d(D0, "adPlanCreateTime");
            int d37 = androidx.room.util.k.d(D0, "appStarDesc");
            int d38 = androidx.room.util.k.d(D0, "appSizeDesc");
            int d39 = androidx.room.util.k.d(D0, "ctxEnableExpr");
            int d40 = androidx.room.util.k.d(D0, "ctxDisableExpr");
            int d41 = androidx.room.util.k.d(D0, "ctxAttributeConfig");
            int d42 = androidx.room.util.k.d(D0, "dispatchTimeStart");
            int d43 = androidx.room.util.k.d(D0, "dispatchTimeEnd");
            int d44 = androidx.room.util.k.d(D0, "extImage");
            int d45 = androidx.room.util.k.d(D0, "bidEcpmCent");
            int d46 = androidx.room.util.k.d(D0, "ecpmCent");
            int d47 = androidx.room.util.k.d(D0, "isValid");
            int d48 = androidx.room.util.k.d(D0, "h5LinkPreload");
            int d49 = androidx.room.util.k.d(D0, "h5LinkOpenByCct");
            int d50 = androidx.room.util.k.d(D0, "countryCode");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n022 = D0.isNull(d11) ? null : D0.n0(d11);
                String n023 = D0.isNull(d12) ? null : D0.n0(d12);
                String n024 = D0.isNull(d13) ? null : D0.n0(d13);
                String n025 = D0.isNull(d14) ? null : D0.n0(d14);
                String n026 = D0.isNull(d15) ? null : D0.n0(d15);
                String n027 = D0.isNull(d16) ? null : D0.n0(d16);
                if (D0.isNull(d17)) {
                    i11 = d12;
                    i12 = d13;
                    valueOf = null;
                } else {
                    i11 = d12;
                    i12 = d13;
                    valueOf = Integer.valueOf((int) D0.getLong(d17));
                }
                Integer valueOf5 = D0.isNull(d18) ? null : Integer.valueOf((int) D0.getLong(d18));
                String n028 = D0.isNull(d19) ? null : D0.n0(d19);
                String n029 = D0.isNull(d20) ? null : D0.n0(d20);
                String n030 = D0.isNull(d21) ? null : D0.n0(d21);
                String n031 = D0.isNull(d22) ? null : D0.n0(d22);
                List b11 = mVar.f68985c.b(D0.isNull(d23) ? null : D0.n0(d23));
                int i39 = d24;
                if (D0.isNull(i39)) {
                    i13 = d11;
                    n02 = null;
                } else {
                    n02 = D0.n0(i39);
                    i13 = d11;
                }
                List b12 = mVar.f68985c.b(n02);
                int i40 = d25;
                if (D0.isNull(i40)) {
                    d25 = i40;
                    n03 = null;
                } else {
                    n03 = D0.n0(i40);
                    d25 = i40;
                }
                List b13 = mVar.f68985c.b(n03);
                int i41 = d26;
                if (D0.isNull(i41)) {
                    d26 = i41;
                    n04 = null;
                } else {
                    n04 = D0.n0(i41);
                    d26 = i41;
                }
                List b14 = mVar.f68985c.b(n04);
                int i42 = d27;
                if (D0.isNull(i42)) {
                    d27 = i42;
                    n05 = null;
                } else {
                    n05 = D0.n0(i42);
                    d27 = i42;
                }
                List b15 = mVar.f68985c.b(n05);
                int i43 = d28;
                if (D0.isNull(i43)) {
                    d28 = i43;
                    n06 = null;
                } else {
                    n06 = D0.n0(i43);
                    d28 = i43;
                }
                List b16 = mVar.f68985c.b(n06);
                int i44 = d29;
                if (D0.isNull(i44)) {
                    i14 = d30;
                    n07 = null;
                } else {
                    n07 = D0.n0(i44);
                    i14 = d30;
                }
                if (D0.isNull(i14)) {
                    d29 = i44;
                    i15 = d31;
                    n08 = null;
                } else {
                    n08 = D0.n0(i14);
                    d29 = i44;
                    i15 = d31;
                }
                if (D0.isNull(i15)) {
                    d31 = i15;
                    i16 = d32;
                    n09 = null;
                } else {
                    d31 = i15;
                    n09 = D0.n0(i15);
                    i16 = d32;
                }
                if (D0.isNull(i16)) {
                    d32 = i16;
                    i17 = d33;
                    n010 = null;
                } else {
                    d32 = i16;
                    n010 = D0.n0(i16);
                    i17 = d33;
                }
                if (D0.isNull(i17)) {
                    i18 = i39;
                    i19 = i14;
                    i20 = d34;
                    valueOf2 = null;
                } else {
                    i18 = i39;
                    i19 = i14;
                    valueOf2 = Integer.valueOf((int) D0.getLong(i17));
                    i20 = d34;
                }
                if (D0.isNull(i20)) {
                    i21 = d35;
                    n011 = null;
                } else {
                    n011 = D0.n0(i20);
                    i21 = d35;
                }
                if (D0.isNull(i21)) {
                    i22 = i17;
                    i23 = d36;
                    n012 = null;
                } else {
                    n012 = D0.n0(i21);
                    i22 = i17;
                    i23 = d36;
                }
                if (D0.isNull(i23)) {
                    d36 = i23;
                    i24 = d37;
                    n013 = null;
                } else {
                    d36 = i23;
                    n013 = D0.n0(i23);
                    i24 = d37;
                }
                if (D0.isNull(i24)) {
                    d37 = i24;
                    i25 = d38;
                    n014 = null;
                } else {
                    d37 = i24;
                    n014 = D0.n0(i24);
                    i25 = d38;
                }
                if (D0.isNull(i25)) {
                    d38 = i25;
                    i26 = d39;
                    n015 = null;
                } else {
                    d38 = i25;
                    n015 = D0.n0(i25);
                    i26 = d39;
                }
                if (D0.isNull(i26)) {
                    d39 = i26;
                    i27 = d40;
                    n016 = null;
                } else {
                    d39 = i26;
                    n016 = D0.n0(i26);
                    i27 = d40;
                }
                if (D0.isNull(i27)) {
                    d40 = i27;
                    i28 = d41;
                    n017 = null;
                } else {
                    d40 = i27;
                    n017 = D0.n0(i27);
                    i28 = d41;
                }
                if (D0.isNull(i28)) {
                    d41 = i28;
                    i29 = d42;
                    n018 = null;
                } else {
                    d41 = i28;
                    n018 = D0.n0(i28);
                    i29 = d42;
                }
                if (D0.isNull(i29)) {
                    d42 = i29;
                    i30 = d43;
                    n019 = null;
                } else {
                    d42 = i29;
                    n019 = D0.n0(i29);
                    i30 = d43;
                }
                if (D0.isNull(i30)) {
                    d43 = i30;
                    i31 = d44;
                    n020 = null;
                } else {
                    d43 = i30;
                    n020 = D0.n0(i30);
                    i31 = d44;
                }
                if (D0.isNull(i31)) {
                    d44 = i31;
                    i32 = d45;
                    n021 = null;
                } else {
                    d44 = i31;
                    n021 = D0.n0(i31);
                    i32 = d45;
                }
                if (D0.isNull(i32)) {
                    d45 = i32;
                    i33 = d46;
                    valueOf3 = null;
                } else {
                    d45 = i32;
                    valueOf3 = Double.valueOf(D0.getDouble(i32));
                    i33 = d46;
                }
                if (D0.isNull(i33)) {
                    d46 = i33;
                    i35 = i20;
                    i34 = d47;
                    valueOf4 = null;
                } else {
                    d46 = i33;
                    valueOf4 = Long.valueOf(D0.getLong(i33));
                    i34 = d47;
                    i35 = i20;
                }
                int i45 = i21;
                if (((int) D0.getLong(i34)) != 0) {
                    i36 = d48;
                    z10 = true;
                } else {
                    i36 = d48;
                    z10 = false;
                }
                int i46 = d14;
                int i47 = i34;
                if (((int) D0.getLong(i36)) != 0) {
                    i37 = d49;
                    z11 = true;
                } else {
                    i37 = d49;
                    z11 = false;
                }
                if (((int) D0.getLong(i37)) != 0) {
                    i38 = d50;
                    z12 = true;
                } else {
                    i38 = d50;
                    z12 = false;
                }
                arrayList.add(new MbAdDbPlans(n022, n023, n024, n025, n026, n027, valueOf, valueOf5, n028, n029, n030, n031, b11, b12, b13, b14, b15, b16, n07, n08, n09, n010, valueOf2, n011, n012, n013, n014, n015, n016, n017, n018, n019, n020, n021, valueOf3, valueOf4, z10, z11, z12, D0.isNull(i38) ? null : D0.n0(i38)));
                mVar = this;
                d50 = i38;
                d49 = i37;
                d13 = i12;
                d11 = i13;
                d24 = i18;
                d30 = i19;
                d33 = i22;
                d34 = i35;
                d35 = i45;
                d47 = i47;
                d14 = i46;
                d48 = i36;
                d12 = i11;
            }
            D0.close();
            return arrayList;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List B(String str, z3.b bVar) {
        int i11;
        int i12;
        Integer valueOf;
        String n02;
        int i13;
        String n03;
        String n04;
        String n05;
        String n06;
        String n07;
        int i14;
        String n08;
        int i15;
        String n09;
        int i16;
        String n010;
        int i17;
        int i18;
        int i19;
        Integer valueOf2;
        int i20;
        String n011;
        int i21;
        String n012;
        int i22;
        int i23;
        String n013;
        int i24;
        String n014;
        int i25;
        String n015;
        int i26;
        String n016;
        int i27;
        String n017;
        int i28;
        String n018;
        int i29;
        String n019;
        int i30;
        String n020;
        int i31;
        String n021;
        int i32;
        Double valueOf3;
        int i33;
        Long valueOf4;
        int i34;
        int i35;
        int i36;
        boolean z10;
        int i37;
        boolean z11;
        int i38;
        boolean z12;
        m mVar = this;
        z3.e D0 = bVar.D0("SELECT * FROM mb_ad_db_plans where adSource=?");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "id");
            int d12 = androidx.room.util.k.d(D0, "version");
            int d13 = androidx.room.util.k.d(D0, "name");
            int d14 = androidx.room.util.k.d(D0, "startTime");
            int d15 = androidx.room.util.k.d(D0, "endTime");
            int d16 = androidx.room.util.k.d(D0, "extraConfig");
            int d17 = androidx.room.util.k.d(D0, "displayTimes");
            int d18 = androidx.room.util.k.d(D0, "showedTimes");
            int d19 = androidx.room.util.k.d(D0, "showDate");
            int d20 = androidx.room.util.k.d(D0, "advertiserName");
            int d21 = androidx.room.util.k.d(D0, "advertiserAvatar");
            int d22 = androidx.room.util.k.d(D0, "advertiserAvatarPath");
            int d23 = androidx.room.util.k.d(D0, "brand");
            int d24 = androidx.room.util.k.d(D0, "denyBrand");
            int d25 = androidx.room.util.k.d(D0, "model");
            int d26 = androidx.room.util.k.d(D0, "denyModel");
            int d27 = androidx.room.util.k.d(D0, PlaceTypes.COUNTRY);
            int d28 = androidx.room.util.k.d(D0, "scenes");
            int d29 = androidx.room.util.k.d(D0, "adSource");
            int d30 = androidx.room.util.k.d(D0, "extAdSlot");
            int d31 = androidx.room.util.k.d(D0, "adMaterialList");
            int d32 = androidx.room.util.k.d(D0, "adPlanUpdateTime");
            int d33 = androidx.room.util.k.d(D0, "sort");
            int d34 = androidx.room.util.k.d(D0, "adShowLevel");
            int d35 = androidx.room.util.k.d(D0, "filterClientVersion");
            int d36 = androidx.room.util.k.d(D0, "adPlanCreateTime");
            int d37 = androidx.room.util.k.d(D0, "appStarDesc");
            int d38 = androidx.room.util.k.d(D0, "appSizeDesc");
            int d39 = androidx.room.util.k.d(D0, "ctxEnableExpr");
            int d40 = androidx.room.util.k.d(D0, "ctxDisableExpr");
            int d41 = androidx.room.util.k.d(D0, "ctxAttributeConfig");
            int d42 = androidx.room.util.k.d(D0, "dispatchTimeStart");
            int d43 = androidx.room.util.k.d(D0, "dispatchTimeEnd");
            int d44 = androidx.room.util.k.d(D0, "extImage");
            int d45 = androidx.room.util.k.d(D0, "bidEcpmCent");
            int d46 = androidx.room.util.k.d(D0, "ecpmCent");
            int d47 = androidx.room.util.k.d(D0, "isValid");
            int d48 = androidx.room.util.k.d(D0, "h5LinkPreload");
            int d49 = androidx.room.util.k.d(D0, "h5LinkOpenByCct");
            int d50 = androidx.room.util.k.d(D0, "countryCode");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n022 = D0.isNull(d11) ? null : D0.n0(d11);
                String n023 = D0.isNull(d12) ? null : D0.n0(d12);
                String n024 = D0.isNull(d13) ? null : D0.n0(d13);
                String n025 = D0.isNull(d14) ? null : D0.n0(d14);
                String n026 = D0.isNull(d15) ? null : D0.n0(d15);
                String n027 = D0.isNull(d16) ? null : D0.n0(d16);
                if (D0.isNull(d17)) {
                    i11 = d12;
                    i12 = d13;
                    valueOf = null;
                } else {
                    i11 = d12;
                    i12 = d13;
                    valueOf = Integer.valueOf((int) D0.getLong(d17));
                }
                Integer valueOf5 = D0.isNull(d18) ? null : Integer.valueOf((int) D0.getLong(d18));
                String n028 = D0.isNull(d19) ? null : D0.n0(d19);
                String n029 = D0.isNull(d20) ? null : D0.n0(d20);
                String n030 = D0.isNull(d21) ? null : D0.n0(d21);
                String n031 = D0.isNull(d22) ? null : D0.n0(d22);
                List b11 = mVar.f68985c.b(D0.isNull(d23) ? null : D0.n0(d23));
                int i39 = d24;
                if (D0.isNull(i39)) {
                    i13 = d11;
                    n02 = null;
                } else {
                    n02 = D0.n0(i39);
                    i13 = d11;
                }
                List b12 = mVar.f68985c.b(n02);
                int i40 = d25;
                if (D0.isNull(i40)) {
                    d25 = i40;
                    n03 = null;
                } else {
                    n03 = D0.n0(i40);
                    d25 = i40;
                }
                List b13 = mVar.f68985c.b(n03);
                int i41 = d26;
                if (D0.isNull(i41)) {
                    d26 = i41;
                    n04 = null;
                } else {
                    n04 = D0.n0(i41);
                    d26 = i41;
                }
                List b14 = mVar.f68985c.b(n04);
                int i42 = d27;
                if (D0.isNull(i42)) {
                    d27 = i42;
                    n05 = null;
                } else {
                    n05 = D0.n0(i42);
                    d27 = i42;
                }
                List b15 = mVar.f68985c.b(n05);
                int i43 = d28;
                if (D0.isNull(i43)) {
                    d28 = i43;
                    n06 = null;
                } else {
                    n06 = D0.n0(i43);
                    d28 = i43;
                }
                List b16 = mVar.f68985c.b(n06);
                int i44 = d29;
                if (D0.isNull(i44)) {
                    i14 = d30;
                    n07 = null;
                } else {
                    n07 = D0.n0(i44);
                    i14 = d30;
                }
                if (D0.isNull(i14)) {
                    d29 = i44;
                    i15 = d31;
                    n08 = null;
                } else {
                    n08 = D0.n0(i14);
                    d29 = i44;
                    i15 = d31;
                }
                if (D0.isNull(i15)) {
                    d31 = i15;
                    i16 = d32;
                    n09 = null;
                } else {
                    d31 = i15;
                    n09 = D0.n0(i15);
                    i16 = d32;
                }
                if (D0.isNull(i16)) {
                    d32 = i16;
                    i17 = d33;
                    n010 = null;
                } else {
                    d32 = i16;
                    n010 = D0.n0(i16);
                    i17 = d33;
                }
                if (D0.isNull(i17)) {
                    i18 = i39;
                    i19 = i14;
                    i20 = d34;
                    valueOf2 = null;
                } else {
                    i18 = i39;
                    i19 = i14;
                    valueOf2 = Integer.valueOf((int) D0.getLong(i17));
                    i20 = d34;
                }
                if (D0.isNull(i20)) {
                    i21 = d35;
                    n011 = null;
                } else {
                    n011 = D0.n0(i20);
                    i21 = d35;
                }
                if (D0.isNull(i21)) {
                    i22 = i17;
                    i23 = d36;
                    n012 = null;
                } else {
                    n012 = D0.n0(i21);
                    i22 = i17;
                    i23 = d36;
                }
                if (D0.isNull(i23)) {
                    d36 = i23;
                    i24 = d37;
                    n013 = null;
                } else {
                    d36 = i23;
                    n013 = D0.n0(i23);
                    i24 = d37;
                }
                if (D0.isNull(i24)) {
                    d37 = i24;
                    i25 = d38;
                    n014 = null;
                } else {
                    d37 = i24;
                    n014 = D0.n0(i24);
                    i25 = d38;
                }
                if (D0.isNull(i25)) {
                    d38 = i25;
                    i26 = d39;
                    n015 = null;
                } else {
                    d38 = i25;
                    n015 = D0.n0(i25);
                    i26 = d39;
                }
                if (D0.isNull(i26)) {
                    d39 = i26;
                    i27 = d40;
                    n016 = null;
                } else {
                    d39 = i26;
                    n016 = D0.n0(i26);
                    i27 = d40;
                }
                if (D0.isNull(i27)) {
                    d40 = i27;
                    i28 = d41;
                    n017 = null;
                } else {
                    d40 = i27;
                    n017 = D0.n0(i27);
                    i28 = d41;
                }
                if (D0.isNull(i28)) {
                    d41 = i28;
                    i29 = d42;
                    n018 = null;
                } else {
                    d41 = i28;
                    n018 = D0.n0(i28);
                    i29 = d42;
                }
                if (D0.isNull(i29)) {
                    d42 = i29;
                    i30 = d43;
                    n019 = null;
                } else {
                    d42 = i29;
                    n019 = D0.n0(i29);
                    i30 = d43;
                }
                if (D0.isNull(i30)) {
                    d43 = i30;
                    i31 = d44;
                    n020 = null;
                } else {
                    d43 = i30;
                    n020 = D0.n0(i30);
                    i31 = d44;
                }
                if (D0.isNull(i31)) {
                    d44 = i31;
                    i32 = d45;
                    n021 = null;
                } else {
                    d44 = i31;
                    n021 = D0.n0(i31);
                    i32 = d45;
                }
                if (D0.isNull(i32)) {
                    d45 = i32;
                    i33 = d46;
                    valueOf3 = null;
                } else {
                    d45 = i32;
                    valueOf3 = Double.valueOf(D0.getDouble(i32));
                    i33 = d46;
                }
                if (D0.isNull(i33)) {
                    d46 = i33;
                    i35 = i20;
                    i34 = d47;
                    valueOf4 = null;
                } else {
                    d46 = i33;
                    valueOf4 = Long.valueOf(D0.getLong(i33));
                    i34 = d47;
                    i35 = i20;
                }
                int i45 = i21;
                if (((int) D0.getLong(i34)) != 0) {
                    i36 = d48;
                    z10 = true;
                } else {
                    i36 = d48;
                    z10 = false;
                }
                int i46 = d14;
                int i47 = i34;
                if (((int) D0.getLong(i36)) != 0) {
                    i37 = d49;
                    z11 = true;
                } else {
                    i37 = d49;
                    z11 = false;
                }
                if (((int) D0.getLong(i37)) != 0) {
                    i38 = d50;
                    z12 = true;
                } else {
                    i38 = d50;
                    z12 = false;
                }
                arrayList.add(new MbAdDbPlans(n022, n023, n024, n025, n026, n027, valueOf, valueOf5, n028, n029, n030, n031, b11, b12, b13, b14, b15, b16, n07, n08, n09, n010, valueOf2, n011, n012, n013, n014, n015, n016, n017, n018, n019, n020, n021, valueOf3, valueOf4, z10, z11, z12, D0.isNull(i38) ? null : D0.n0(i38)));
                mVar = this;
                d50 = i38;
                d49 = i37;
                d13 = i12;
                d11 = i13;
                d24 = i18;
                d30 = i19;
                d33 = i22;
                d34 = i35;
                d35 = i45;
                d47 = i47;
                d14 = i46;
                d48 = i36;
                d12 = i11;
            }
            D0.close();
            return arrayList;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit C(MbAdDbPlans mbAdDbPlans, z3.b bVar) {
        this.f68984b.d(bVar, mbAdDbPlans);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit D(List list, z3.b bVar) {
        this.f68984b.c(bVar, list);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit E(MbAdDbPlans mbAdDbPlans, z3.b bVar) {
        this.f68986d.c(bVar, mbAdDbPlans);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit F(boolean z10, String str, z3.b bVar) {
        z3.e D0 = bVar.D0("UPDATE mb_ad_db_plans SET isValid = ? WHERE version !=?");
        try {
            D0.c(1, z10 ? 1L : 0L);
            if (str == null) {
                D0.g(2);
            } else {
                D0.j(2, str);
            }
            D0.A0();
            Unit unit = Unit.f67184a;
            D0.close();
            return unit;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    public static List v() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit w(String str, z3.b bVar) {
        z3.e D0 = bVar.D0("DELETE FROM mb_ad_db_plans WHERE version !=?");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            D0.A0();
            Unit unit = Unit.f67184a;
            D0.close();
            return unit;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer x(z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT COUNT(*) FROM mb_ad_db_plans");
        try {
            Integer num = null;
            if (D0.A0() && !D0.isNull(0)) {
                num = Integer.valueOf((int) D0.getLong(0));
            }
            return num;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List y(z3.b bVar) {
        int i11;
        int i12;
        Integer valueOf;
        String n02;
        int i13;
        String n03;
        String n04;
        String n05;
        String n06;
        String n07;
        int i14;
        String n08;
        int i15;
        String n09;
        int i16;
        String n010;
        int i17;
        int i18;
        int i19;
        Integer valueOf2;
        int i20;
        String n011;
        int i21;
        String n012;
        int i22;
        int i23;
        String n013;
        int i24;
        String n014;
        int i25;
        String n015;
        int i26;
        String n016;
        int i27;
        String n017;
        int i28;
        String n018;
        int i29;
        String n019;
        int i30;
        String n020;
        int i31;
        String n021;
        int i32;
        Double valueOf3;
        int i33;
        Long valueOf4;
        int i34;
        int i35;
        int i36;
        boolean z10;
        int i37;
        boolean z11;
        m mVar = this;
        z3.e D0 = bVar.D0("SELECT * FROM mb_ad_db_plans WHERE isValid = 1 ORDER BY sort");
        try {
            int d11 = androidx.room.util.k.d(D0, "id");
            int d12 = androidx.room.util.k.d(D0, "version");
            int d13 = androidx.room.util.k.d(D0, "name");
            int d14 = androidx.room.util.k.d(D0, "startTime");
            int d15 = androidx.room.util.k.d(D0, "endTime");
            int d16 = androidx.room.util.k.d(D0, "extraConfig");
            int d17 = androidx.room.util.k.d(D0, "displayTimes");
            int d18 = androidx.room.util.k.d(D0, "showedTimes");
            int d19 = androidx.room.util.k.d(D0, "showDate");
            int d20 = androidx.room.util.k.d(D0, "advertiserName");
            int d21 = androidx.room.util.k.d(D0, "advertiserAvatar");
            int d22 = androidx.room.util.k.d(D0, "advertiserAvatarPath");
            int d23 = androidx.room.util.k.d(D0, "brand");
            int d24 = androidx.room.util.k.d(D0, "denyBrand");
            int d25 = androidx.room.util.k.d(D0, "model");
            int d26 = androidx.room.util.k.d(D0, "denyModel");
            int d27 = androidx.room.util.k.d(D0, PlaceTypes.COUNTRY);
            int d28 = androidx.room.util.k.d(D0, "scenes");
            int d29 = androidx.room.util.k.d(D0, "adSource");
            int d30 = androidx.room.util.k.d(D0, "extAdSlot");
            int d31 = androidx.room.util.k.d(D0, "adMaterialList");
            int d32 = androidx.room.util.k.d(D0, "adPlanUpdateTime");
            int d33 = androidx.room.util.k.d(D0, "sort");
            int d34 = androidx.room.util.k.d(D0, "adShowLevel");
            int d35 = androidx.room.util.k.d(D0, "filterClientVersion");
            int d36 = androidx.room.util.k.d(D0, "adPlanCreateTime");
            int d37 = androidx.room.util.k.d(D0, "appStarDesc");
            int d38 = androidx.room.util.k.d(D0, "appSizeDesc");
            int d39 = androidx.room.util.k.d(D0, "ctxEnableExpr");
            int d40 = androidx.room.util.k.d(D0, "ctxDisableExpr");
            int d41 = androidx.room.util.k.d(D0, "ctxAttributeConfig");
            int d42 = androidx.room.util.k.d(D0, "dispatchTimeStart");
            int d43 = androidx.room.util.k.d(D0, "dispatchTimeEnd");
            int d44 = androidx.room.util.k.d(D0, "extImage");
            int d45 = androidx.room.util.k.d(D0, "bidEcpmCent");
            int d46 = androidx.room.util.k.d(D0, "ecpmCent");
            int d47 = androidx.room.util.k.d(D0, "isValid");
            int d48 = androidx.room.util.k.d(D0, "h5LinkPreload");
            int d49 = androidx.room.util.k.d(D0, "h5LinkOpenByCct");
            int d50 = androidx.room.util.k.d(D0, "countryCode");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n022 = D0.isNull(d11) ? null : D0.n0(d11);
                String n023 = D0.isNull(d12) ? null : D0.n0(d12);
                String n024 = D0.isNull(d13) ? null : D0.n0(d13);
                String n025 = D0.isNull(d14) ? null : D0.n0(d14);
                String n026 = D0.isNull(d15) ? null : D0.n0(d15);
                String n027 = D0.isNull(d16) ? null : D0.n0(d16);
                if (D0.isNull(d17)) {
                    i11 = d12;
                    i12 = d13;
                    valueOf = null;
                } else {
                    i11 = d12;
                    i12 = d13;
                    valueOf = Integer.valueOf((int) D0.getLong(d17));
                }
                Integer valueOf5 = D0.isNull(d18) ? null : Integer.valueOf((int) D0.getLong(d18));
                String n028 = D0.isNull(d19) ? null : D0.n0(d19);
                String n029 = D0.isNull(d20) ? null : D0.n0(d20);
                String n030 = D0.isNull(d21) ? null : D0.n0(d21);
                String n031 = D0.isNull(d22) ? null : D0.n0(d22);
                List b11 = mVar.f68985c.b(D0.isNull(d23) ? null : D0.n0(d23));
                int i38 = d24;
                if (D0.isNull(i38)) {
                    i13 = d11;
                    n02 = null;
                } else {
                    n02 = D0.n0(i38);
                    i13 = d11;
                }
                List b12 = mVar.f68985c.b(n02);
                int i39 = d25;
                if (D0.isNull(i39)) {
                    d25 = i39;
                    n03 = null;
                } else {
                    n03 = D0.n0(i39);
                    d25 = i39;
                }
                List b13 = mVar.f68985c.b(n03);
                int i40 = d26;
                if (D0.isNull(i40)) {
                    d26 = i40;
                    n04 = null;
                } else {
                    n04 = D0.n0(i40);
                    d26 = i40;
                }
                List b14 = mVar.f68985c.b(n04);
                int i41 = d27;
                if (D0.isNull(i41)) {
                    d27 = i41;
                    n05 = null;
                } else {
                    n05 = D0.n0(i41);
                    d27 = i41;
                }
                List b15 = mVar.f68985c.b(n05);
                int i42 = d28;
                if (D0.isNull(i42)) {
                    d28 = i42;
                    n06 = null;
                } else {
                    n06 = D0.n0(i42);
                    d28 = i42;
                }
                List b16 = mVar.f68985c.b(n06);
                int i43 = d29;
                if (D0.isNull(i43)) {
                    i14 = d30;
                    n07 = null;
                } else {
                    n07 = D0.n0(i43);
                    i14 = d30;
                }
                if (D0.isNull(i14)) {
                    d29 = i43;
                    i15 = d31;
                    n08 = null;
                } else {
                    n08 = D0.n0(i14);
                    d29 = i43;
                    i15 = d31;
                }
                if (D0.isNull(i15)) {
                    d31 = i15;
                    i16 = d32;
                    n09 = null;
                } else {
                    d31 = i15;
                    n09 = D0.n0(i15);
                    i16 = d32;
                }
                if (D0.isNull(i16)) {
                    d32 = i16;
                    i17 = d33;
                    n010 = null;
                } else {
                    d32 = i16;
                    n010 = D0.n0(i16);
                    i17 = d33;
                }
                if (D0.isNull(i17)) {
                    i18 = i38;
                    i19 = i14;
                    i20 = d34;
                    valueOf2 = null;
                } else {
                    i18 = i38;
                    i19 = i14;
                    valueOf2 = Integer.valueOf((int) D0.getLong(i17));
                    i20 = d34;
                }
                if (D0.isNull(i20)) {
                    i21 = d35;
                    n011 = null;
                } else {
                    n011 = D0.n0(i20);
                    i21 = d35;
                }
                if (D0.isNull(i21)) {
                    i22 = i17;
                    i23 = d36;
                    n012 = null;
                } else {
                    n012 = D0.n0(i21);
                    i22 = i17;
                    i23 = d36;
                }
                if (D0.isNull(i23)) {
                    d36 = i23;
                    i24 = d37;
                    n013 = null;
                } else {
                    d36 = i23;
                    n013 = D0.n0(i23);
                    i24 = d37;
                }
                if (D0.isNull(i24)) {
                    d37 = i24;
                    i25 = d38;
                    n014 = null;
                } else {
                    d37 = i24;
                    n014 = D0.n0(i24);
                    i25 = d38;
                }
                if (D0.isNull(i25)) {
                    d38 = i25;
                    i26 = d39;
                    n015 = null;
                } else {
                    d38 = i25;
                    n015 = D0.n0(i25);
                    i26 = d39;
                }
                if (D0.isNull(i26)) {
                    d39 = i26;
                    i27 = d40;
                    n016 = null;
                } else {
                    d39 = i26;
                    n016 = D0.n0(i26);
                    i27 = d40;
                }
                if (D0.isNull(i27)) {
                    d40 = i27;
                    i28 = d41;
                    n017 = null;
                } else {
                    d40 = i27;
                    n017 = D0.n0(i27);
                    i28 = d41;
                }
                if (D0.isNull(i28)) {
                    d41 = i28;
                    i29 = d42;
                    n018 = null;
                } else {
                    d41 = i28;
                    n018 = D0.n0(i28);
                    i29 = d42;
                }
                if (D0.isNull(i29)) {
                    d42 = i29;
                    i30 = d43;
                    n019 = null;
                } else {
                    d42 = i29;
                    n019 = D0.n0(i29);
                    i30 = d43;
                }
                if (D0.isNull(i30)) {
                    d43 = i30;
                    i31 = d44;
                    n020 = null;
                } else {
                    d43 = i30;
                    n020 = D0.n0(i30);
                    i31 = d44;
                }
                if (D0.isNull(i31)) {
                    d44 = i31;
                    i32 = d45;
                    n021 = null;
                } else {
                    d44 = i31;
                    n021 = D0.n0(i31);
                    i32 = d45;
                }
                if (D0.isNull(i32)) {
                    d45 = i32;
                    i33 = d46;
                    valueOf3 = null;
                } else {
                    d45 = i32;
                    valueOf3 = Double.valueOf(D0.getDouble(i32));
                    i33 = d46;
                }
                if (D0.isNull(i33)) {
                    d46 = i33;
                    i35 = i20;
                    i34 = d47;
                    valueOf4 = null;
                } else {
                    d46 = i33;
                    valueOf4 = Long.valueOf(D0.getLong(i33));
                    i34 = d47;
                    i35 = i20;
                }
                int i44 = i21;
                if (((int) D0.getLong(i34)) != 0) {
                    i36 = d48;
                    z10 = true;
                } else {
                    i36 = d48;
                    z10 = false;
                }
                int i45 = d14;
                int i46 = d49;
                boolean z12 = ((int) D0.getLong(i36)) != 0;
                int i47 = i34;
                if (((int) D0.getLong(i46)) != 0) {
                    i37 = d50;
                    z11 = true;
                } else {
                    i37 = d50;
                    z11 = false;
                }
                arrayList.add(new MbAdDbPlans(n022, n023, n024, n025, n026, n027, valueOf, valueOf5, n028, n029, n030, n031, b11, b12, b13, b14, b15, b16, n07, n08, n09, n010, valueOf2, n011, n012, n013, n014, n015, n016, n017, n018, n019, n020, n021, valueOf3, valueOf4, z10, z12, z11, D0.isNull(i37) ? null : D0.n0(i37)));
                mVar = this;
                d50 = i37;
                d13 = i12;
                d11 = i13;
                d24 = i18;
                d30 = i19;
                d33 = i22;
                d34 = i35;
                d35 = i44;
                d47 = i47;
                d49 = i46;
                d14 = i45;
                d48 = i36;
                d12 = i11;
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ MbAdDbPlans z(String str, z3.b bVar) {
        String n02;
        int i11;
        String n03;
        int i12;
        String n04;
        int i13;
        String n05;
        int i14;
        Integer valueOf;
        int i15;
        String n06;
        int i16;
        String n07;
        int i17;
        String n08;
        int i18;
        String n09;
        int i19;
        String n010;
        int i20;
        String n011;
        int i21;
        String n012;
        int i22;
        String n013;
        int i23;
        String n014;
        int i24;
        String n015;
        int i25;
        String n016;
        int i26;
        Double valueOf2;
        int i27;
        Long valueOf3;
        int i28;
        boolean z10;
        int i29;
        boolean z11;
        int i30;
        z3.e D0 = bVar.D0("SELECT * FROM mb_ad_db_plans where id=?");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "id");
            int d12 = androidx.room.util.k.d(D0, "version");
            int d13 = androidx.room.util.k.d(D0, "name");
            int d14 = androidx.room.util.k.d(D0, "startTime");
            int d15 = androidx.room.util.k.d(D0, "endTime");
            int d16 = androidx.room.util.k.d(D0, "extraConfig");
            int d17 = androidx.room.util.k.d(D0, "displayTimes");
            int d18 = androidx.room.util.k.d(D0, "showedTimes");
            int d19 = androidx.room.util.k.d(D0, "showDate");
            int d20 = androidx.room.util.k.d(D0, "advertiserName");
            int d21 = androidx.room.util.k.d(D0, "advertiserAvatar");
            int d22 = androidx.room.util.k.d(D0, "advertiserAvatarPath");
            int d23 = androidx.room.util.k.d(D0, "brand");
            int d24 = androidx.room.util.k.d(D0, "denyBrand");
            int d25 = androidx.room.util.k.d(D0, "model");
            int d26 = androidx.room.util.k.d(D0, "denyModel");
            int d27 = androidx.room.util.k.d(D0, PlaceTypes.COUNTRY);
            int d28 = androidx.room.util.k.d(D0, "scenes");
            int d29 = androidx.room.util.k.d(D0, "adSource");
            int d30 = androidx.room.util.k.d(D0, "extAdSlot");
            int d31 = androidx.room.util.k.d(D0, "adMaterialList");
            int d32 = androidx.room.util.k.d(D0, "adPlanUpdateTime");
            int d33 = androidx.room.util.k.d(D0, "sort");
            int d34 = androidx.room.util.k.d(D0, "adShowLevel");
            int d35 = androidx.room.util.k.d(D0, "filterClientVersion");
            int d36 = androidx.room.util.k.d(D0, "adPlanCreateTime");
            int d37 = androidx.room.util.k.d(D0, "appStarDesc");
            int d38 = androidx.room.util.k.d(D0, "appSizeDesc");
            int d39 = androidx.room.util.k.d(D0, "ctxEnableExpr");
            int d40 = androidx.room.util.k.d(D0, "ctxDisableExpr");
            int d41 = androidx.room.util.k.d(D0, "ctxAttributeConfig");
            int d42 = androidx.room.util.k.d(D0, "dispatchTimeStart");
            int d43 = androidx.room.util.k.d(D0, "dispatchTimeEnd");
            int d44 = androidx.room.util.k.d(D0, "extImage");
            int d45 = androidx.room.util.k.d(D0, "bidEcpmCent");
            int d46 = androidx.room.util.k.d(D0, "ecpmCent");
            int d47 = androidx.room.util.k.d(D0, "isValid");
            int d48 = androidx.room.util.k.d(D0, "h5LinkPreload");
            int d49 = androidx.room.util.k.d(D0, "h5LinkOpenByCct");
            int d50 = androidx.room.util.k.d(D0, "countryCode");
            MbAdDbPlans mbAdDbPlans = null;
            if (D0.A0()) {
                String n017 = D0.isNull(d11) ? null : D0.n0(d11);
                String n018 = D0.isNull(d12) ? null : D0.n0(d12);
                String n019 = D0.isNull(d13) ? null : D0.n0(d13);
                String n020 = D0.isNull(d14) ? null : D0.n0(d14);
                String n021 = D0.isNull(d15) ? null : D0.n0(d15);
                String n022 = D0.isNull(d16) ? null : D0.n0(d16);
                Integer valueOf4 = D0.isNull(d17) ? null : Integer.valueOf((int) D0.getLong(d17));
                Integer valueOf5 = D0.isNull(d18) ? null : Integer.valueOf((int) D0.getLong(d18));
                String n023 = D0.isNull(d19) ? null : D0.n0(d19);
                String n024 = D0.isNull(d20) ? null : D0.n0(d20);
                String n025 = D0.isNull(d21) ? null : D0.n0(d21);
                String n026 = D0.isNull(d22) ? null : D0.n0(d22);
                List b11 = this.f68985c.b(D0.isNull(d23) ? null : D0.n0(d23));
                List b12 = this.f68985c.b(D0.isNull(d24) ? null : D0.n0(d24));
                List b13 = this.f68985c.b(D0.isNull(d25) ? null : D0.n0(d25));
                List b14 = this.f68985c.b(D0.isNull(d26) ? null : D0.n0(d26));
                List b15 = this.f68985c.b(D0.isNull(d27) ? null : D0.n0(d27));
                List b16 = this.f68985c.b(D0.isNull(d28) ? null : D0.n0(d28));
                if (D0.isNull(d29)) {
                    i11 = d30;
                    n02 = null;
                } else {
                    n02 = D0.n0(d29);
                    i11 = d30;
                }
                if (D0.isNull(i11)) {
                    i12 = d31;
                    n03 = null;
                } else {
                    n03 = D0.n0(i11);
                    i12 = d31;
                }
                if (D0.isNull(i12)) {
                    i13 = d32;
                    n04 = null;
                } else {
                    n04 = D0.n0(i12);
                    i13 = d32;
                }
                if (D0.isNull(i13)) {
                    i14 = d33;
                    n05 = null;
                } else {
                    n05 = D0.n0(i13);
                    i14 = d33;
                }
                if (D0.isNull(i14)) {
                    i15 = d34;
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf((int) D0.getLong(i14));
                    i15 = d34;
                }
                if (D0.isNull(i15)) {
                    i16 = d35;
                    n06 = null;
                } else {
                    n06 = D0.n0(i15);
                    i16 = d35;
                }
                if (D0.isNull(i16)) {
                    i17 = d36;
                    n07 = null;
                } else {
                    n07 = D0.n0(i16);
                    i17 = d36;
                }
                if (D0.isNull(i17)) {
                    i18 = d37;
                    n08 = null;
                } else {
                    n08 = D0.n0(i17);
                    i18 = d37;
                }
                if (D0.isNull(i18)) {
                    i19 = d38;
                    n09 = null;
                } else {
                    n09 = D0.n0(i18);
                    i19 = d38;
                }
                if (D0.isNull(i19)) {
                    i20 = d39;
                    n010 = null;
                } else {
                    n010 = D0.n0(i19);
                    i20 = d39;
                }
                if (D0.isNull(i20)) {
                    i21 = d40;
                    n011 = null;
                } else {
                    n011 = D0.n0(i20);
                    i21 = d40;
                }
                if (D0.isNull(i21)) {
                    i22 = d41;
                    n012 = null;
                } else {
                    n012 = D0.n0(i21);
                    i22 = d41;
                }
                if (D0.isNull(i22)) {
                    i23 = d42;
                    n013 = null;
                } else {
                    n013 = D0.n0(i22);
                    i23 = d42;
                }
                if (D0.isNull(i23)) {
                    i24 = d43;
                    n014 = null;
                } else {
                    n014 = D0.n0(i23);
                    i24 = d43;
                }
                if (D0.isNull(i24)) {
                    i25 = d44;
                    n015 = null;
                } else {
                    n015 = D0.n0(i24);
                    i25 = d44;
                }
                if (D0.isNull(i25)) {
                    i26 = d45;
                    n016 = null;
                } else {
                    n016 = D0.n0(i25);
                    i26 = d45;
                }
                if (D0.isNull(i26)) {
                    i27 = d46;
                    valueOf2 = null;
                } else {
                    valueOf2 = Double.valueOf(D0.getDouble(i26));
                    i27 = d46;
                }
                if (D0.isNull(i27)) {
                    i28 = d47;
                    valueOf3 = null;
                } else {
                    valueOf3 = Long.valueOf(D0.getLong(i27));
                    i28 = d47;
                }
                if (((int) D0.getLong(i28)) != 0) {
                    i29 = d48;
                    z10 = true;
                } else {
                    z10 = false;
                    i29 = d48;
                }
                if (((int) D0.getLong(i29)) != 0) {
                    i30 = d49;
                    z11 = true;
                } else {
                    z11 = false;
                    i30 = d49;
                }
                mbAdDbPlans = new MbAdDbPlans(n017, n018, n019, n020, n021, n022, valueOf4, valueOf5, n023, n024, n025, n026, b11, b12, b13, b14, b15, b16, n02, n03, n04, n05, valueOf, n06, n07, n08, n09, n010, n011, n012, n013, n014, n015, n016, valueOf2, valueOf3, z10, z11, ((int) D0.getLong(i30)) != 0, D0.isNull(d50) ? null : D0.n0(d50));
            }
            D0.close();
            return mbAdDbPlans;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    @Override // li.b
    public Object a(final List list, Continuation continuation) {
        list.getClass();
        return androidx.room.util.b.f(this.f68983a, false, true, new Function1() { // from class: li.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit D;
                D = m.this.D(list, (z3.b) obj);
                return D;
            }
        }, continuation);
    }

    @Override // li.b
    public Object b(Continuation continuation) {
        return androidx.room.util.b.f(this.f68983a, true, false, new Function1() { // from class: li.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List y10;
                y10 = m.this.y((z3.b) obj);
                return y10;
            }
        }, continuation);
    }

    @Override // li.b
    public Object c(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f68983a, true, false, new Function1() { // from class: li.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List A;
                A = m.this.A(str, (z3.b) obj);
                return A;
            }
        }, continuation);
    }

    @Override // li.b
    public Object d(Continuation continuation) {
        return androidx.room.util.b.f(this.f68983a, true, false, new Function1() { // from class: li.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Integer x10;
                x10 = m.x((z3.b) obj);
                return x10;
            }
        }, continuation);
    }

    @Override // li.b
    public Object e(final MbAdDbPlans mbAdDbPlans, Continuation continuation) {
        mbAdDbPlans.getClass();
        return androidx.room.util.b.f(this.f68983a, false, true, new Function1() { // from class: li.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit C;
                C = m.this.C(mbAdDbPlans, (z3.b) obj);
                return C;
            }
        }, continuation);
    }

    @Override // li.b
    public Object f(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f68983a, false, true, new Function1() { // from class: li.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit w11;
                w11 = m.w(str, (z3.b) obj);
                return w11;
            }
        }, continuation);
    }

    @Override // li.b
    public Object g(final boolean z10, final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f68983a, false, true, new Function1() { // from class: li.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit F;
                F = m.F(z10, str, (z3.b) obj);
                return F;
            }
        }, continuation);
    }

    @Override // li.b
    public Object h(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f68983a, true, false, new Function1() { // from class: li.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                MbAdDbPlans z10;
                z10 = m.this.z(str, (z3.b) obj);
                return z10;
            }
        }, continuation);
    }

    @Override // li.b
    public Object i(final MbAdDbPlans mbAdDbPlans, Continuation continuation) {
        mbAdDbPlans.getClass();
        return androidx.room.util.b.f(this.f68983a, false, true, new Function1() { // from class: li.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit E;
                E = m.this.E(mbAdDbPlans, (z3.b) obj);
                return E;
            }
        }, continuation);
    }

    @Override // li.b
    public Object j(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f68983a, true, false, new Function1() { // from class: li.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List B;
                B = m.this.B(str, (z3.b) obj);
                return B;
            }
        }, continuation);
    }
}
