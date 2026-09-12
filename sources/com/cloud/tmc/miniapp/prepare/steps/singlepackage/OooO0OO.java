package com.cloud.tmc.miniapp.prepare.steps.singlepackage;

import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.resource.IPackageResourceManager;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class OooO0OO extends com.cloud.tmc.miniapp.prepare.steps.structure.OooO0OO {
    public final void OooO00o(AppModel appModel, List<File> list, Map<String, String> map, HashMap<String, String> hashMap, IPackageResourceManager iPackageResourceManager, String str) {
        if (list != null) {
            for (File file : list) {
                if (file.isDirectory()) {
                    OooO00o(appModel, Arrays.asList(file.listFiles()), map, hashMap, iPackageResourceManager, str + "/" + file.getName());
                } else {
                    String generateVUrl = iPackageResourceManager.generateVUrl(file.getAbsolutePath(), appModel.getAppId(), file.getName(), str);
                    StringBuilder OooO00o = com.cloud.tmc.miniapp.OooO00o.OooO00o("StartStep:absPath:");
                    OooO00o.append(file.getAbsolutePath());
                    OooO00o.append(";vUrl:");
                    OooO00o.append(generateVUrl);
                    TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, OooO00o.toString());
                    map.put(file.getName(), generateVUrl);
                    if (file.getName().toLowerCase().contains(".html")) {
                        hashMap.put(file.getName(), generateVUrl);
                    }
                    String str2 = this.OooO00o;
                    StringBuilder OooO00o2 = com.cloud.tmc.miniapp.OooO00o.OooO00o("Step_LoadStep: tar包结构: ");
                    OooO00o2.append(file.getName());
                    TmcLogger.d(str2, OooO00o2.toString());
                    TmcLogger.d(this.OooO00o, "Step_LoadStep: tar包结构: " + generateVUrl);
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:99|100|(2:20|21)|(19:23|26|27|(0)|29|(0)(0)|40|41|42|(0)(0)|48|49|50|(0)|54|(0)|65|66|67)|92|29|(0)(0)|40|41|42|(0)(0)|48|49|50|(0)|54|(0)|65|66|67) */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x02b8, code lost:
    
        r4 = r20;
        r28.moveToError(new com.cloud.tmc.miniapp.prepare.steps.PrepareException(r6, r4));
        r7 = r19;
        com.cloud.tmc.kernel.log.TmcLogger.d(r27.OooO00o, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x027a, code lost:
    
        r5 = r25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x025f A[Catch: all -> 0x027a, TRY_LEAVE, TryCatch #6 {all -> 0x027a, blocks: (B:42:0x0257, B:44:0x025f), top: B:41:0x0257 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x029d A[Catch: all -> 0x02b8, TRY_LEAVE, TryCatch #3 {all -> 0x02b8, blocks: (B:50:0x0295, B:52:0x029d), top: B:49:0x0295 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02db A[Catch: all -> 0x02f2, TRY_LEAVE, TryCatch #2 {all -> 0x02f2, blocks: (B:60:0x02d3, B:62:0x02db), top: B:59:0x02d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r17v8, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r20v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r27v0, types: [com.cloud.tmc.miniapp.prepare.steps.singlepackage.OooO0OO, com.cloud.tmc.miniapp.prepare.steps.OooO00o] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r4v18, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.util.HashMap] */
    @Override // com.cloud.tmc.miniapp.prepare.steps.structure.OooO0OO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.cloud.tmc.integration.model.PrepareCallbackParam OooO0OO(com.cloud.tmc.miniapp.prepare.controller.PrepareController r28, com.cloud.tmc.integration.model.PrepareContext r29, com.cloud.tmc.miniapp.prepare.steps.o000oOoO r30) {
        /*
            Method dump skipped, instructions count: 797
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.prepare.steps.singlepackage.OooO0OO.OooO0OO(com.cloud.tmc.miniapp.prepare.controller.PrepareController, com.cloud.tmc.integration.model.PrepareContext, com.cloud.tmc.miniapp.prepare.steps.o000oOoO):com.cloud.tmc.integration.model.PrepareCallbackParam");
    }
}
