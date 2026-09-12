package com.tencent.tinker.loader.hotplug;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ast.ASTNode;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public final class IncrementComponentManager {
    private static Context sContext;
    private static volatile boolean sInitialized;
    private static String sPackageName;
    private static final Map<String, ActivityInfo> CLASS_NAME_TO_ACTIVITY_INFO_MAP = new HashMap();
    private static final Map<String, IntentFilter> CLASS_NAME_TO_INTENT_FILTER_MAP = new HashMap();
    private static final AttrTranslator<ActivityInfo> ACTIVITY_INFO_ATTR_TRANSLATOR = new AttrTranslator<ActivityInfo>() { // from class: com.tencent.tinker.loader.hotplug.IncrementComponentManager.1
        private int parseLaunchMode(String str) {
            if ("standard".equalsIgnoreCase(str)) {
                return 0;
            }
            if ("singleTop".equalsIgnoreCase(str)) {
                return 1;
            }
            if ("singleTask".equalsIgnoreCase(str)) {
                return 2;
            }
            if ("singleInstance".equalsIgnoreCase(str)) {
                return 3;
            }
            ShareTinkerLog.w("Tinker.IncrementCompMgr", "Unknown launchMode: " + str, new Object[0]);
            return 0;
        }

        private int parseScreenOrientation(String str) {
            if ("unspecified".equalsIgnoreCase(str)) {
                return -1;
            }
            if ("behind".equalsIgnoreCase(str)) {
                return 3;
            }
            if (TmcStartParams.KEY_LANDSCAPE.equalsIgnoreCase(str)) {
                return 0;
            }
            if ("portrait".equalsIgnoreCase(str)) {
                return 1;
            }
            if ("reverseLandscape".equalsIgnoreCase(str)) {
                return 8;
            }
            if ("reversePortrait".equalsIgnoreCase(str)) {
                return 9;
            }
            if ("sensorLandscape".equalsIgnoreCase(str)) {
                return 6;
            }
            if ("sensorPortrait".equalsIgnoreCase(str)) {
                return 7;
            }
            if ("sensor".equalsIgnoreCase(str)) {
                return 4;
            }
            if ("fullSensor".equalsIgnoreCase(str)) {
                return 10;
            }
            if ("nosensor".equalsIgnoreCase(str)) {
                return 5;
            }
            if ("user".equalsIgnoreCase(str)) {
                return 2;
            }
            if ("fullUser".equalsIgnoreCase(str)) {
                return 13;
            }
            if ("locked".equalsIgnoreCase(str)) {
                return 14;
            }
            if ("userLandscape".equalsIgnoreCase(str)) {
                return 11;
            }
            return "userPortrait".equalsIgnoreCase(str) ? 12 : -1;
        }

        @Override // com.tencent.tinker.loader.hotplug.IncrementComponentManager.AttrTranslator
        void onInit(Context context, int i11, XmlPullParser xmlPullParser) {
            if (i11 == 0) {
                try {
                    if (xmlPullParser.getEventType() == 2 && "activity".equals(xmlPullParser.getName())) {
                    } else {
                        throw new IllegalStateException("unexpected xml parser state when parsing incremental component manifest.");
                    }
                } catch (XmlPullParserException e11) {
                    throw new IllegalStateException(e11);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.tinker.loader.hotplug.IncrementComponentManager.AttrTranslator
        public void onTranslate(Context context, int i11, String str, String str2, ActivityInfo activityInfo) {
            int i12 = 0;
            if ("name".equals(str)) {
                if (str2.charAt(0) != '.') {
                    activityInfo.name = str2;
                    return;
                }
                activityInfo.name = context.getPackageName() + str2;
                return;
            }
            if ("parentActivityName".equals(str)) {
                if (str2.charAt(0) != '.') {
                    activityInfo.parentActivityName = str2;
                    return;
                }
                activityInfo.parentActivityName = context.getPackageName() + str2;
                return;
            }
            if ("exported".equals(str)) {
                activityInfo.exported = "true".equalsIgnoreCase(str2);
                return;
            }
            if (TmcConstants.EXTRA_LAUNCH_MODE.equals(str)) {
                activityInfo.launchMode = parseLaunchMode(str2);
                return;
            }
            if ("theme".equals(str)) {
                activityInfo.theme = context.getResources().getIdentifier(str2, TtmlNode.TAG_STYLE, context.getPackageName());
                return;
            }
            if ("uiOptions".equals(str)) {
                activityInfo.uiOptions = Integer.decode(str2).intValue();
                return;
            }
            if (TmcConstants.MENU_KEY_PERMISSION.equals(str)) {
                activityInfo.permission = str2;
                return;
            }
            if ("taskAffinity".equals(str)) {
                activityInfo.taskAffinity = str2;
                return;
            }
            if ("multiprocess".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 1;
                    return;
                } else {
                    activityInfo.flags &= -2;
                    return;
                }
            }
            if ("finishOnTaskLaunch".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 2;
                    return;
                } else {
                    activityInfo.flags &= -3;
                    return;
                }
            }
            if ("clearTaskOnLaunch".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 4;
                    return;
                } else {
                    activityInfo.flags &= -5;
                    return;
                }
            }
            if ("noHistory".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 128;
                    return;
                } else {
                    activityInfo.flags &= -129;
                    return;
                }
            }
            if ("alwaysRetainTaskState".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 8;
                    return;
                } else {
                    activityInfo.flags &= -9;
                    return;
                }
            }
            if ("stateNotNeeded".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 16;
                    return;
                } else {
                    activityInfo.flags &= -17;
                    return;
                }
            }
            if ("excludeFromRecents".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 32;
                    return;
                } else {
                    activityInfo.flags &= -33;
                    return;
                }
            }
            if ("allowTaskReparenting".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 64;
                    return;
                } else {
                    activityInfo.flags &= -65;
                    return;
                }
            }
            if ("finishOnCloseSystemDialogs".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 256;
                    return;
                } else {
                    activityInfo.flags &= -257;
                    return;
                }
            }
            if ("showOnLockScreen".equals(str) || "showForAllUsers".equals(str)) {
                int valueOfStaticIntField = ShareReflectUtil.getValueOfStaticIntField(ActivityInfo.class, "FLAG_SHOW_FOR_ALL_USERS", 0);
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags = valueOfStaticIntField | activityInfo.flags;
                    return;
                } else {
                    activityInfo.flags = (~valueOfStaticIntField) & activityInfo.flags;
                    return;
                }
            }
            if ("immersive".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 2048;
                    return;
                } else {
                    activityInfo.flags &= -2049;
                    return;
                }
            }
            if ("hardwareAccelerated".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 512;
                    return;
                } else {
                    activityInfo.flags &= -513;
                    return;
                }
            }
            if ("documentLaunchMode".equals(str)) {
                activityInfo.documentLaunchMode = Integer.decode(str2).intValue();
                return;
            }
            if ("maxRecents".equals(str)) {
                activityInfo.maxRecents = Integer.decode(str2).intValue();
                return;
            }
            if ("configChanges".equals(str)) {
                activityInfo.configChanges = Integer.decode(str2).intValue();
                return;
            }
            if ("windowSoftInputMode".equals(str)) {
                activityInfo.softInputMode = Integer.decode(str2).intValue();
                return;
            }
            if ("persistableMode".equals(str)) {
                activityInfo.persistableMode = Integer.decode(str2).intValue();
                return;
            }
            if ("allowEmbedded".equals(str)) {
                int valueOfStaticIntField2 = ShareReflectUtil.getValueOfStaticIntField(ActivityInfo.class, "FLAG_ALLOW_EMBEDDED", 0);
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags = valueOfStaticIntField2 | activityInfo.flags;
                    return;
                } else {
                    activityInfo.flags = (~valueOfStaticIntField2) & activityInfo.flags;
                    return;
                }
            }
            if ("autoRemoveFromRecents".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 8192;
                    return;
                } else {
                    activityInfo.flags &= -8193;
                    return;
                }
            }
            if ("relinquishTaskIdentity".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 4096;
                    return;
                } else {
                    activityInfo.flags &= -4097;
                    return;
                }
            }
            if ("resumeWhilePausing".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 16384;
                    return;
                } else {
                    activityInfo.flags &= -16385;
                    return;
                }
            }
            if ("screenOrientation".equals(str)) {
                activityInfo.screenOrientation = parseScreenOrientation(str2);
                return;
            }
            if ("label".equals(str)) {
                try {
                    i12 = context.getResources().getIdentifier(str2, "string", IncrementComponentManager.sPackageName);
                } catch (Throwable unused) {
                }
                if (i12 != 0) {
                    activityInfo.labelRes = i12;
                    return;
                } else {
                    activityInfo.nonLocalizedLabel = str2;
                    return;
                }
            }
            try {
                if (RewardPlus.ICON.equals(str)) {
                    activityInfo.icon = context.getResources().getIdentifier(str2, null, IncrementComponentManager.sPackageName);
                } else if ("banner".equals(str)) {
                    activityInfo.banner = context.getResources().getIdentifier(str2, null, IncrementComponentManager.sPackageName);
                } else if (!"logo".equals(str)) {
                } else {
                    activityInfo.logo = context.getResources().getIdentifier(str2, null, IncrementComponentManager.sPackageName);
                }
            } catch (Throwable unused2) {
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static abstract class AttrTranslator<T_RESULT> {
        private AttrTranslator() {
        }

        void onInit(Context context, int i11, XmlPullParser xmlPullParser) {
        }

        abstract void onTranslate(Context context, int i11, String str, String str2, T_RESULT t_result);

        final void translate(Context context, int i11, XmlPullParser xmlPullParser, T_RESULT t_result) {
            onInit(context, i11, xmlPullParser);
            int attributeCount = xmlPullParser.getAttributeCount();
            for (int i12 = 0; i12 < attributeCount; i12++) {
                if ("android".equals(xmlPullParser.getAttributePrefix(i12))) {
                    onTranslate(context, i11, xmlPullParser.getAttributeName(i12), xmlPullParser.getAttributeValue(i12), t_result);
                }
            }
        }
    }

    private IncrementComponentManager() {
        throw new UnsupportedOperationException();
    }

    private static synchronized void ensureInitialized() {
        synchronized (IncrementComponentManager.class) {
            if (!sInitialized) {
                throw new IllegalStateException("Not initialized!!");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [org.xmlpull.v1.XmlPullParser] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized boolean init(android.content.Context r6, com.tencent.tinker.loader.shareutil.ShareSecurityCheck r7) throws java.io.IOException {
        /*
            java.lang.Class<com.tencent.tinker.loader.hotplug.IncrementComponentManager> r0 = com.tencent.tinker.loader.hotplug.IncrementComponentManager.class
            monitor-enter(r0)
            java.util.HashMap r1 = r7.getMetaContentMap()     // Catch: java.lang.Throwable -> L1b
            java.lang.String r2 = "assets/inc_component_meta.txt"
            boolean r1 = r1.containsKey(r2)     // Catch: java.lang.Throwable -> L1b
            if (r1 != 0) goto L1e
            java.lang.String r6 = "Tinker.IncrementCompMgr"
            java.lang.String r7 = "package has no incremental component meta, skip init."
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L1b
            com.tencent.tinker.loader.shareutil.ShareTinkerLog.i(r6, r7, r2)     // Catch: java.lang.Throwable -> L1b
            monitor-exit(r0)
            return r1
        L1b:
            r6 = move-exception
            goto Lb0
        L1e:
            boolean r1 = r6 instanceof android.content.ContextWrapper     // Catch: java.lang.Throwable -> L1b
            if (r1 == 0) goto L2e
            r1 = r6
            android.content.ContextWrapper r1 = (android.content.ContextWrapper) r1     // Catch: java.lang.Throwable -> L1b
            android.content.Context r1 = r1.getBaseContext()     // Catch: java.lang.Throwable -> L1b
            if (r1 != 0) goto L2c
            goto L2e
        L2c:
            r6 = r1
            goto L1e
        L2e:
            com.tencent.tinker.loader.hotplug.IncrementComponentManager.sContext = r6     // Catch: java.lang.Throwable -> L1b
            java.lang.String r1 = r6.getPackageName()     // Catch: java.lang.Throwable -> L1b
            com.tencent.tinker.loader.hotplug.IncrementComponentManager.sPackageName = r1     // Catch: java.lang.Throwable -> L1b
            java.util.HashMap r7 = r7.getMetaContentMap()     // Catch: java.lang.Throwable -> L1b
            java.lang.String r1 = "assets/inc_component_meta.txt"
            java.lang.Object r7 = r7.get(r1)     // Catch: java.lang.Throwable -> L1b
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> L1b
            java.io.StringReader r1 = new java.io.StringReader     // Catch: java.lang.Throwable -> L1b
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L1b
            r7 = 0
            org.xmlpull.v1.XmlPullParser r2 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L9c org.xmlpull.v1.XmlPullParserException -> L9f
            r2.setInput(r1)     // Catch: java.lang.Throwable -> L72 org.xmlpull.v1.XmlPullParserException -> L74
            int r3 = r2.getEventType()     // Catch: java.lang.Throwable -> L72 org.xmlpull.v1.XmlPullParserException -> L74
        L53:
            r4 = 1
            if (r3 == r4) goto L92
            r4 = 2
            if (r3 == r4) goto L5a
            goto L8d
        L5a:
            java.lang.String r3 = r2.getName()     // Catch: java.lang.Throwable -> L72 org.xmlpull.v1.XmlPullParserException -> L74
            java.lang.String r4 = "activity"
            boolean r4 = r4.equalsIgnoreCase(r3)     // Catch: java.lang.Throwable -> L72 org.xmlpull.v1.XmlPullParserException -> L74
            if (r4 == 0) goto L76
            android.content.pm.ActivityInfo r3 = parseActivity(r6, r2)     // Catch: java.lang.Throwable -> L72 org.xmlpull.v1.XmlPullParserException -> L74
            java.util.Map<java.lang.String, android.content.pm.ActivityInfo> r4 = com.tencent.tinker.loader.hotplug.IncrementComponentManager.CLASS_NAME_TO_ACTIVITY_INFO_MAP     // Catch: java.lang.Throwable -> L72 org.xmlpull.v1.XmlPullParserException -> L74
            java.lang.String r5 = r3.name     // Catch: java.lang.Throwable -> L72 org.xmlpull.v1.XmlPullParserException -> L74
            r4.put(r5, r3)     // Catch: java.lang.Throwable -> L72 org.xmlpull.v1.XmlPullParserException -> L74
            goto L8d
        L72:
            r6 = move-exception
            goto La7
        L74:
            r6 = move-exception
            goto La1
        L76:
            java.lang.String r4 = "service"
            boolean r4 = r4.equalsIgnoreCase(r3)     // Catch: java.lang.Throwable -> L72 org.xmlpull.v1.XmlPullParserException -> L74
            if (r4 == 0) goto L7f
            goto L8d
        L7f:
            java.lang.String r4 = "receiver"
            boolean r4 = r4.equalsIgnoreCase(r3)     // Catch: java.lang.Throwable -> L72 org.xmlpull.v1.XmlPullParserException -> L74
            if (r4 == 0) goto L88
            goto L8d
        L88:
            java.lang.String r4 = "provider"
            r4.equalsIgnoreCase(r3)     // Catch: java.lang.Throwable -> L72 org.xmlpull.v1.XmlPullParserException -> L74
        L8d:
            int r3 = r2.next()     // Catch: java.lang.Throwable -> L72 org.xmlpull.v1.XmlPullParserException -> L74
            goto L53
        L92:
            com.tencent.tinker.loader.hotplug.IncrementComponentManager.sInitialized = r4     // Catch: java.lang.Throwable -> L72 org.xmlpull.v1.XmlPullParserException -> L74
            r2.setInput(r7)     // Catch: java.lang.Throwable -> L97
        L97:
            com.tencent.tinker.loader.shareutil.SharePatchFileUtil.closeQuietly(r1)     // Catch: java.lang.Throwable -> L1b
            monitor-exit(r0)
            return r4
        L9c:
            r6 = move-exception
            r2 = r7
            goto La7
        L9f:
            r6 = move-exception
            r2 = r7
        La1:
            java.io.IOException r3 = new java.io.IOException     // Catch: java.lang.Throwable -> L72
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L72
            throw r3     // Catch: java.lang.Throwable -> L72
        La7:
            if (r2 == 0) goto Lac
            r2.setInput(r7)     // Catch: java.lang.Throwable -> Lac
        Lac:
            com.tencent.tinker.loader.shareutil.SharePatchFileUtil.closeQuietly(r1)     // Catch: java.lang.Throwable -> L1b
            throw r6     // Catch: java.lang.Throwable -> L1b
        Lb0:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1b
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.hotplug.IncrementComponentManager.init(android.content.Context, com.tencent.tinker.loader.shareutil.ShareSecurityCheck):boolean");
    }

    public static boolean isIncrementActivity(String str) {
        ensureInitialized();
        return str != null && CLASS_NAME_TO_ACTIVITY_INFO_MAP.containsKey(str);
    }

    private static synchronized ActivityInfo parseActivity(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ActivityInfo activityInfo;
        synchronized (IncrementComponentManager.class) {
            try {
                activityInfo = new ActivityInfo();
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                activityInfo.applicationInfo = applicationInfo;
                activityInfo.packageName = sPackageName;
                activityInfo.processName = applicationInfo.processName;
                activityInfo.launchMode = 0;
                activityInfo.permission = applicationInfo.permission;
                activityInfo.screenOrientation = -1;
                activityInfo.taskAffinity = applicationInfo.taskAffinity;
                if ((applicationInfo.flags & ASTNode.DISCARD) != 0) {
                    activityInfo.flags |= 512;
                }
                activityInfo.documentLaunchMode = 0;
                activityInfo.uiOptions = applicationInfo.uiOptions;
                ACTIVITY_INFO_ATTR_TRANSLATOR.translate(context, 0, xmlPullParser, activityInfo);
                int depth = xmlPullParser.getDepth();
                while (true) {
                    int next = xmlPullParser.next();
                    if (next == 1 || (next == 3 && xmlPullParser.getDepth() <= depth)) {
                        break;
                    }
                    if (next != 3 && next != 4) {
                        String name = xmlPullParser.getName();
                        if ("intent-filter".equalsIgnoreCase(name)) {
                            parseIntentFilter(context, activityInfo.name, xmlPullParser);
                        } else if ("meta-data".equalsIgnoreCase(name)) {
                            parseMetaData(context, activityInfo, xmlPullParser);
                        }
                    }
                }
            } finally {
            }
        }
        return activityInfo;
    }

    private static synchronized void parseIntentFilter(Context context, String str, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        synchronized (IncrementComponentManager.class) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                String attributeValue = xmlPullParser.getAttributeValue(null, TrackingKey.PRIORITY);
                if (!TextUtils.isEmpty(attributeValue)) {
                    intentFilter.setPriority(Integer.decode(attributeValue).intValue());
                }
                String attributeValue2 = xmlPullParser.getAttributeValue(null, "autoVerify");
                if (!TextUtils.isEmpty(attributeValue2)) {
                    try {
                        ShareReflectUtil.findMethod((Class<?>) IntentFilter.class, "setAutoVerify", (Class<?>[]) new Class[]{Boolean.TYPE}).invoke(intentFilter, Boolean.valueOf("true".equalsIgnoreCase(attributeValue2)));
                    } catch (Throwable unused) {
                    }
                }
                int depth = xmlPullParser.getDepth();
                while (true) {
                    int next = xmlPullParser.next();
                    if (next == 1 || (next == 3 && xmlPullParser.getDepth() <= depth)) {
                        break;
                    }
                    if (next != 3 && next != 4) {
                        String name = xmlPullParser.getName();
                        if (EventConstants.KEY_ACTION.equals(name)) {
                            String attributeValue3 = xmlPullParser.getAttributeValue(null, "name");
                            if (attributeValue3 != null) {
                                intentFilter.addAction(attributeValue3);
                            }
                        } else if ("category".equals(name)) {
                            String attributeValue4 = xmlPullParser.getAttributeValue(null, "name");
                            if (attributeValue4 != null) {
                                intentFilter.addCategory(attributeValue4);
                            }
                        } else if ("data".equals(name)) {
                            String attributeValue5 = xmlPullParser.getAttributeValue(null, "mimeType");
                            if (attributeValue5 != null) {
                                try {
                                    intentFilter.addDataType(attributeValue5);
                                } catch (IntentFilter.MalformedMimeTypeException e11) {
                                    throw new XmlPullParserException("bad mimeType", xmlPullParser, e11);
                                }
                            }
                            String attributeValue6 = xmlPullParser.getAttributeValue(null, "scheme");
                            if (attributeValue6 != null) {
                                intentFilter.addDataScheme(attributeValue6);
                            }
                            String attributeValue7 = xmlPullParser.getAttributeValue(null, "ssp");
                            if (attributeValue7 != null) {
                                intentFilter.addDataSchemeSpecificPart(attributeValue7, 0);
                            }
                            String attributeValue8 = xmlPullParser.getAttributeValue(null, "sspPrefix");
                            if (attributeValue8 != null) {
                                intentFilter.addDataSchemeSpecificPart(attributeValue8, 1);
                            }
                            String attributeValue9 = xmlPullParser.getAttributeValue(null, "sspPattern");
                            if (attributeValue9 != null) {
                                intentFilter.addDataSchemeSpecificPart(attributeValue9, 2);
                            }
                            String attributeValue10 = xmlPullParser.getAttributeValue(null, "host");
                            String attributeValue11 = xmlPullParser.getAttributeValue(null, "port");
                            if (attributeValue10 != null) {
                                intentFilter.addDataAuthority(attributeValue10, attributeValue11);
                            }
                            String attributeValue12 = xmlPullParser.getAttributeValue(null, "path");
                            if (attributeValue12 != null) {
                                intentFilter.addDataPath(attributeValue12, 0);
                            }
                            String attributeValue13 = xmlPullParser.getAttributeValue(null, "pathPrefix");
                            if (attributeValue13 != null) {
                                intentFilter.addDataPath(attributeValue13, 1);
                            }
                            String attributeValue14 = xmlPullParser.getAttributeValue(null, "pathPattern");
                            if (attributeValue14 != null) {
                                intentFilter.addDataPath(attributeValue14, 2);
                            }
                        }
                        skipCurrentTag(xmlPullParser);
                    }
                }
                CLASS_NAME_TO_INTENT_FILTER_MAP.put(str, intentFilter);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static synchronized void parseMetaData(Context context, ActivityInfo activityInfo, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        synchronized (IncrementComponentManager.class) {
            try {
                ClassLoader classLoader = IncrementComponentManager.class.getClassLoader();
                String attributeValue = xmlPullParser.getAttributeValue(null, "name");
                String attributeValue2 = xmlPullParser.getAttributeValue(null, AppMeasurementSdk.ConditionalUserProperty.VALUE);
                if (!TextUtils.isEmpty(attributeValue)) {
                    if (activityInfo.metaData == null) {
                        activityInfo.metaData = new Bundle(classLoader);
                    }
                    activityInfo.metaData.putString(attributeValue, attributeValue2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static ActivityInfo queryActivityInfo(String str) {
        ensureInitialized();
        if (str != null) {
            return CLASS_NAME_TO_ACTIVITY_INFO_MAP.get(str);
        }
        return null;
    }

    public static ResolveInfo resolveIntent(Intent intent) {
        IntentFilter intentFilter;
        String str;
        ensureInitialized();
        ComponentName component = intent.getComponent();
        int i11 = -1;
        int i12 = 0;
        if (component != null) {
            str = component.getClassName();
            if (CLASS_NAME_TO_ACTIVITY_INFO_MAP.containsKey(str)) {
                i11 = 0;
            } else {
                str = null;
            }
            intentFilter = null;
        } else {
            int i13 = -1;
            String str2 = null;
            intentFilter = null;
            int i14 = 0;
            for (Map.Entry<String, IntentFilter> entry : CLASS_NAME_TO_INTENT_FILTER_MAP.entrySet()) {
                String key = entry.getKey();
                IntentFilter value = entry.getValue();
                int match = value.match(intent.getAction(), intent.getType(), intent.getScheme(), intent.getData(), intent.getCategories(), "Tinker.IncrementCompMgr");
                boolean z10 = (match == -3 || match == -4 || match == -2 || match == -1) ? false : true;
                int priority = value.getPriority();
                if (z10 && priority > i13) {
                    intentFilter = value;
                    str2 = key;
                    i14 = match;
                    i13 = priority;
                }
            }
            str = str2;
            i11 = i13;
            i12 = i14;
        }
        if (str == null) {
            return null;
        }
        ResolveInfo resolveInfo = new ResolveInfo();
        ActivityInfo activityInfo = CLASS_NAME_TO_ACTIVITY_INFO_MAP.get(str);
        resolveInfo.activityInfo = activityInfo;
        resolveInfo.filter = intentFilter;
        resolveInfo.match = i12;
        resolveInfo.priority = i11;
        resolveInfo.resolvePackageName = sPackageName;
        resolveInfo.icon = activityInfo.icon;
        resolveInfo.labelRes = activityInfo.labelRes;
        return resolveInfo;
    }

    private static void skipCurrentTag(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return;
            }
        }
    }
}
