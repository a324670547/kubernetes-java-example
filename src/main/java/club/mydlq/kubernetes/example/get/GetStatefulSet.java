package club.mydlq.kubernetes.example.get;

import io.kubernetes.client.ApiException;
import io.kubernetes.client.apis.AppsV1Api;
import io.kubernetes.client.models.V1StatefulSet;
import io.kubernetes.client.models.V1StatefulSetList;

/**
 * - 描述：获取 Statefulset
 * - API版本： apps/v1
 */
public class GetStatefulSet {

    /**
     * 获取全部 Namespace 的 Statefulset 列表
     */
    public static void getAllStatefulSet() throws ApiException {
        // 设置 Api 客户端
        AppsV1Api appsV1Api = new AppsV1Api();
        // 获取全部 Namespace 下的 Statefulset 列表
        V1StatefulSetList statefulSetList = appsV1Api.listStatefulSetForAllNamespaces(null, null, null, null, null, null, null, null, null);
        for (V1StatefulSet item : statefulSetList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的 Statefulset 列表
     */
    public static void getNamespaceStatefulSetList(String namespace) throws ApiException {
        // 设置 Api 客户端
        AppsV1Api appsV1Api = new AppsV1Api();
        // 获取某个 Namespace 下的 Statefulset 列表
        V1StatefulSetList statefulSetList = appsV1Api.listNamespacedStatefulSet(namespace, null, null, null, null, null, null, null, null, null);
        for (V1StatefulSet item : statefulSetList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的某个 Statefulset
     */
    public static void getNamespaceStatefulSet(String namespace,String statefulSetName) throws ApiException {
        // 设置 Api 客户端
        AppsV1Api appsV1Api = new AppsV1Api();
        // 获取某个 Namespace 下的 Statefulset 列表
        V1StatefulSet statefulSet = appsV1Api.readNamespacedStatefulSet(statefulSetName , namespace, null, null, null);
        System.out.println(statefulSet);
    }

    /**
     * 获取 Statefulset
     */
    public static void main(String[] args) throws Exception {
        // 连接 Kubernetes 集群
        ConnectKubernetes.connectFromTokenByFile();
        // 获取 Kubernetes 集群的全部 Statefulset
        getAllStatefulSet();
        // 获取某个 Namespace 下的 Statefulset 列表
        getNamespaceStatefulSetList("namespace");
        // 获取某个 Namespace 的某个 Statefulset
        getNamespaceStatefulSet("namespace","statefulset");
    }

}
