package com.cloud.tmc.integration.invoke.extension;

import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.cloud.tmc.integration.permission.AppPermissionManager;
import com.cloud.tmc.integration.permission.PermissionManager;
import com.cloud.tmc.integration.permission.model.TmcGroupInit;
import com.cloud.tmc.integration.permission.proxy.AuthenticationProxy;
import com.cloud.tmc.integration.permission.whitelist.BridgeWhiteList;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.bridge.NativeCallContext;
import com.cloud.tmc.kernel.helper.BridgeResponseHelper;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.NodeAware;
import com.cloud.tmc.kernel.point.BridgeAccessPoint;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.security.Accessor;
import com.cloud.tmc.kernel.security.Group;
import com.cloud.tmc.kernel.security.Guard;
import com.cloud.tmc.kernel.security.Permission;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes3.dex */
public class BridgeAccessExtension implements BridgeAccessPoint, NodeAware<Page> {
    private static final String TAG = ":Permission";
    private WeakReference<Page> pageReference;
    private PermissionManager permissionManager;

    public BridgeAccessExtension() {
        TmcGroupInit.init();
    }

    @Override // com.cloud.tmc.kernel.point.BridgeAccessPoint
    public boolean asyncCheckPermission(Permission permission, Accessor accessor, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) {
        boolean asyncCheckPermission = this.permissionManager.asyncCheckPermission(permission, accessor, nativeCallContext, bridgeResponseHelper);
        TmcLogger.d(TAG, nativeCallContext.getId() + "|" + permission.authority() + "|accessor" + accessor.hashCode() + "#async check permission result=" + asyncCheckPermission);
        return asyncCheckPermission;
    }

    @Override // com.cloud.tmc.kernel.point.BridgeAccessPoint
    public boolean bizCheckPermission(Permission permission, Accessor accessor, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) {
        boolean bizCheckPermission = this.permissionManager.bizCheckPermission(permission, accessor, nativeCallContext, bridgeResponseHelper);
        TmcLogger.d(TAG, nativeCallContext.getId() + IntegrationConstants.TOOL_SPLIT + permission.authority() + IntegrationConstants.TOOL_SPLIT + "accessor" + accessor.hashCode() + "#biz check permission result=" + bizCheckPermission);
        return bizCheckPermission;
    }

    @Override // com.cloud.tmc.kernel.point.BridgeAccessPoint
    public boolean checkPermission(Permission permission, Accessor accessor, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) {
        boolean checkPermission = this.permissionManager.checkPermission(permission, accessor, nativeCallContext, bridgeResponseHelper);
        TmcLogger.d(TAG, nativeCallContext.getId() + IntegrationConstants.TOOL_SPLIT + permission.authority() + IntegrationConstants.TOOL_SPLIT + "accessor" + accessor.hashCode() + IntegrationConstants.TOOL_SPLIT + "check permission result=" + checkPermission);
        return checkPermission;
    }

    @Override // com.cloud.tmc.kernel.node.NodeAware
    public Class<Page> getNodeType() {
        return Page.class;
    }

    @Override // com.cloud.tmc.kernel.point.BridgeAccessPoint
    public Group manageAccessorGroup(Accessor accessor) {
        TmcGroupInit.init();
        Group manageAccessorGroup = this.permissionManager.manageAccessorGroup(accessor);
        TmcLogger.d(TAG, "accessor" + accessor.hashCode() + " group=" + manageAccessorGroup.groupName());
        return manageAccessorGroup;
    }

    @Override // com.cloud.tmc.kernel.point.BridgeAccessPoint
    public List<Permission> manageAccessorPermissions(Accessor accessor) {
        List<Permission> manageAccessorPermissions = this.permissionManager.manageAccessorPermissions(accessor);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("accessor");
        sb2.append(accessor.hashCode());
        sb2.append(" permission list size=");
        sb2.append(manageAccessorPermissions == null ? "0" : Integer.valueOf(manageAccessorPermissions.size()));
        TmcLogger.d(TAG, sb2.toString());
        return manageAccessorPermissions;
    }

    @Override // com.cloud.tmc.kernel.point.BridgeAccessPoint
    public boolean needPermissionCheck(Accessor accessor, List<? extends Guard> list) {
        if (this.permissionManager == null) {
            AppPermissionManager appPermissionManager = new AppPermissionManager(null);
            this.permissionManager = appPermissionManager;
            appPermissionManager.init(accessor);
        }
        if (list != null && list.size() > 0) {
            for (Guard guard : list) {
                if (guard.permit() != null && BridgeWhiteList.isInWhiteList(guard.permit().authority())) {
                    return false;
                }
            }
        }
        WeakReference<Page> weakReference = this.pageReference;
        if (weakReference == null || weakReference.get() == null || this.pageReference.get().getApp() == null || ((AuthenticationProxy) TmcProxy.get(AuthenticationProxy.class)).hasPermissionModel(this.pageReference.get().getApp().getAppId(), this.pageReference.get())) {
            return true;
        }
        TmcLogger.d(TAG, "accessor" + accessor.hashCode() + " dont have permission model");
        return false;
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.kernel.node.NodeAware
    public void setNode(WeakReference<Page> weakReference) {
        this.pageReference = weakReference;
    }
}
