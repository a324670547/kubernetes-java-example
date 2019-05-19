package club.mydlq.kubernetes.example.get;

import io.kubernetes.client.ApiException;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1PersistentVolumeClaim;
import io.kubernetes.client.models.V1PersistentVolumeClaimList;

/**
 * - 描述：获取 PersistentVolumeClaim
 * - API版本： v1
 */
public class PersistentVolumeClaim {

    /**
     * 获取全部 Namespace 的 PVC 列表
     */
    public static void getAllPVC() throws ApiException {
        // 设置 Api 客户端
        CoreV1Api api = new CoreV1Api();
        // 获取全部 Namespace 的 PVC 列表
        V1PersistentVolumeClaimList PVCList = api.listPersistentVolumeClaimForAllNamespaces(null, null, null, null, null, null, null, null, null);
        for (V1PersistentVolumeClaim item : PVCList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的 PVC 列表
     */
    public static void getNamespacePVCList(String namespace) throws ApiException {
        // 设置 Api 客户端
        CoreV1Api api = new CoreV1Api();
        // 获取某个 Namespace 的 PVC 列表
        V1PersistentVolumeClaimList PVCList = api.listNamespacedPersistentVolumeClaim(namespace, null, null, null, null, null, null, null, null, null);
        for (V1PersistentVolumeClaim item : PVCList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 PVC
     */
    public static void getNamespacePVC(String namespace, String PVCName) throws ApiException {
        // 设置 Api 客户端
        CoreV1Api api = new CoreV1Api();
        // 获取某个 PVC
        V1PersistentVolumeClaim PVC = api.readNamespacedPersistentVolumeClaim(PVCName, namespace, null,null, null);
        System.out.println(PVC);
    }

    /**
     * 获取 PVC
     */
    public static void main(String[] args) throws Exception {
        // 连接 Kubernetes 集群
        ConnectKubernetes.connectFromTokenByFile();
        // 获取 Kubernetes 集群的全部 PVC
        getAllPVC();
        // 获取某个 Namespace 下的 PVC 列表
        getNamespacePVCList("namespace");
        // 获取某个 Namespace 的某个 PVC
        getNamespacePVC("namespace","PVCName");
    }

}
