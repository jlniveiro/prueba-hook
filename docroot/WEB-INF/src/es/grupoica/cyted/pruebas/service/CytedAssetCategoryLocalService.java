package es.grupoica.cyted.pruebas.service;

import com.liferay.portlet.asset.service.AssetCategoryLocalServiceWrapper;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalService;

public class CytedAssetCategoryLocalService extends AssetCategoryLocalServiceWrapper {
	/* (non-Java-doc)
	 * @see com.liferay.portlet.asset.service.AssetCategoryLocalServiceWrapper#AssetCategoryLocalServiceWrapper(AssetCategoryLocalService assetCategoryLocalService)
	 */
	public CytedAssetCategoryLocalService(AssetCategoryLocalService assetCategoryLocalService) {
		super(assetCategoryLocalService);
	}

	@Override
	public void addAssetEntryAssetCategory(long entryId, AssetCategory assetCategory) throws SystemException {
		// TODO Auto-generated method stub
		super.addAssetEntryAssetCategory(entryId, assetCategory);
	}
	
	

}