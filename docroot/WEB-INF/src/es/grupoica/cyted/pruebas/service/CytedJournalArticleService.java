package es.grupoica.cyted.pruebas.service;

import com.liferay.portlet.journal.service.JournalArticleServiceWrapper;
import com.liferay.portlet.journal.service.persistence.JournalArticlePersistence;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.announcements.model.AnnouncementsEntry;
import com.liferay.portlet.announcements.service.persistence.AnnouncementsEntryPersistence;
import com.liferay.portlet.announcements.service.persistence.AnnouncementsEntryUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleService;

//import com.liferay.tasks.service.TasksEntryServiceUtil;



public class CytedJournalArticleService extends JournalArticleServiceWrapper {
	
	
	
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	protected com.liferay.portal.service.UserLocalService userLocalService;
	protected JournalArticlePersistence journalArticlePersistence;
	protected AnnouncementsEntryPersistence announcementsEntryPersistence;
		
	

	/* (non-Java-doc)
	 * @see com.liferay.portlet.journal.service.JournalArticleServiceWrapper#JournalArticleServiceWrapper(JournalArticleService journalArticleService)
	 */
	public CytedJournalArticleService(JournalArticleService journalArticleService) {
		super(journalArticleService);
	}
	
	

	@Override
	public JournalArticle addArticle(long groupId, long folderId, long classNameId, long classPK, String articleId,
			boolean autoArticleId, Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String content,
			String type, String ddmStructureKey, String ddmTemplateKey, String layoutUuid, int displayDateMonth,
			int displayDateDay, int displayDateYear, int displayDateHour, int displayDateMinute,
			int expirationDateMonth, int expirationDateDay, int expirationDateYear, int expirationDateHour,
			int expirationDateMinute, boolean neverExpire, int reviewDateMonth, int reviewDateDay, int reviewDateYear,
			int reviewDateHour, int reviewDateMinute, boolean neverReview, boolean indexable, boolean smallImage,
			String smallImageURL, File smallFile, Map<String, byte[]> images, String articleURL,
			ServiceContext serviceContext) throws PortalException, SystemException {

		// 
		JournalArticle journalArticle =  super.addArticle(groupId, folderId, classNameId, classPK, articleId, autoArticleId, titleMap, descriptionMap,
				content, type, ddmStructureKey, ddmTemplateKey, layoutUuid, displayDateMonth, displayDateDay, displayDateYear,
				displayDateHour, displayDateMinute, expirationDateMonth, expirationDateDay, expirationDateYear,
				expirationDateHour, expirationDateMinute, neverExpire, reviewDateMonth, reviewDateDay, reviewDateYear,
				reviewDateHour, reviewDateMinute, neverReview, indexable, smallImage, smallImageURL, smallFile, images,
				articleURL, serviceContext);
		
		
		
		return journalArticle;
	}

	@Override
	public JournalArticle addArticle(long groupId, long folderId, long classNameId, long classPK, String articleId,
			boolean autoArticleId, Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String content,
			String type, String ddmStructureKey, String ddmTemplateKey, String layoutUuid, int displayDateMonth,
			int displayDateDay, int displayDateYear, int displayDateHour, int displayDateMinute,
			int expirationDateMonth, int expirationDateDay, int expirationDateYear, int expirationDateHour,
			int expirationDateMinute, boolean neverExpire, int reviewDateMonth, int reviewDateDay, int reviewDateYear,
			int reviewDateHour, int reviewDateMinute, boolean neverReview, boolean indexable, String articleURL,
			ServiceContext serviceContext) throws PortalException, SystemException {

		JournalArticle journalArticle = super.addArticle(groupId, folderId, classNameId, classPK, articleId, autoArticleId, titleMap, descriptionMap,
				content, type, ddmStructureKey, ddmTemplateKey, layoutUuid, displayDateMonth, displayDateDay, displayDateYear,
				displayDateHour, displayDateMinute, expirationDateMonth, expirationDateDay, expirationDateYear,
				expirationDateHour, expirationDateMinute, neverExpire, reviewDateMonth, reviewDateDay, reviewDateYear,
				reviewDateHour, reviewDateMinute, neverReview, indexable, articleURL, serviceContext);
		
		return journalArticle;
	}

	@Override
	public JournalArticle updateArticle(long userId, long groupId, long folderId, String articleId, double version,
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String content, String layoutUuid,
			ServiceContext serviceContext) throws PortalException, SystemException {
		// TODO Auto-generated method stub
		JournalArticle journalArticle = super.updateArticle(userId, groupId, folderId, articleId, version, titleMap, descriptionMap, content, layoutUuid,
				serviceContext);
		
				
		return journalArticle;
	}
	
	
	private AssetCategory getSiguienteFlujo (AssetCategory categActual, List<AssetCategory> categoriasFlujo){
		
		AssetCategory siguiente = null;
		
		boolean encontrado = false;
		
		//recorremos las categorias del flujo y obtenemos la siguiente al actual
		if (categActual == null){
			//Si no tiene categoría asignada, le ponemos la primera
			siguiente = !categoriasFlujo.isEmpty() ? categoriasFlujo.get(0) : null;
		}
		else {
			for (AssetCategory cat : categoriasFlujo){
				if (cat.compareTo(categActual) == 0){
					encontrado = true;
				}
				else if (encontrado){
					siguiente = cat;
					break;
				}
			}
		}//fin if
			
		return siguiente;
	}
	
	
	/**
	 * Obtiene el contenido de un determinado campo del JournalArticle especificado.
	 * @param fieldname
	 * @param article
	 * @param locale
	 * @return
	 */
	private String getParseValue(String fieldname, JournalArticle article, String locale) {
		String value = "";
		 try {

		      Document document = SAXReaderUtil.read(article.getContentByLocale(locale));
		      Node node = document.selectSingleNode("/root/dynamic-element[@name='" + fieldname +"']/dynamic-content");
		       value = node.getText(); 
		} catch(Exception e){
			e.printStackTrace();
		}

		return value; 

	}
	
	
	
	

	@Override
	public JournalArticle updateArticle(long groupId, long folderId, String articleId, double version,
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String content, String type,
			String ddmStructureKey, String ddmTemplateKey, String layoutUuid, int displayDateMonth, int displayDateDay,
			int displayDateYear, int displayDateHour, int displayDateMinute, int expirationDateMonth,
			int expirationDateDay, int expirationDateYear, int expirationDateHour, int expirationDateMinute,
			boolean neverExpire, int reviewDateMonth, int reviewDateDay, int reviewDateYear, int reviewDateHour,
			int reviewDateMinute, boolean neverReview, boolean indexable, boolean smallImage, String smallImageURL,
			File smallFile, Map<String, byte[]> images, String articleURL, ServiceContext serviceContext)
			throws PortalException, SystemException {
		
				
		
		// TODO Auto-generated method stub
		JournalArticle journalArticle = super.updateArticle(groupId, folderId, articleId, version, titleMap, descriptionMap, content, type,
				ddmStructureKey, ddmTemplateKey, layoutUuid, displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
				displayDateMinute, expirationDateMonth, expirationDateDay, expirationDateYear, expirationDateHour,
				expirationDateMinute, neverExpire, reviewDateMonth, reviewDateDay, reviewDateYear, reviewDateHour,
				reviewDateMinute, neverReview, indexable, smallImage, smallImageURL, smallFile, images, articleURL,
				serviceContext);
		
		//Obtenemos la descripción de la Solicitud
		String descripcion = this.getParseValue("Descripcionn", journalArticle, LocaleUtil.getDefault().toString());
		System.out.println("DESCRIPCIÓN DEL CONTENIDO: " + descripcion);
		
		//Obtenemos las categorias asociadas al Artículo
		List<AssetCategory> categories = AssetCategoryLocalServiceUtil.getCategories(JournalArticle.class.getName(), journalArticle.getResourcePrimKey());
		//Obtenemos las categorias del Vocabulario del flujo
		// Get vocabulary "vocabulary.my-voc" (from myGroup)
		AssetVocabulary vocabulary = AssetVocabularyLocalServiceUtil.getGroupVocabulary(journalArticle.getGroupId(), "Flujo solicitud");
		List<AssetCategory> categoriasFlujo =  AssetCategoryLocalServiceUtil.getVocabularyCategories(vocabulary.getVocabularyId(), 
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
		
		//Categoria De FLUJO actual
		AssetCategory categActual = null;
		for (AssetCategory categoria : categories){
			if (categoriasFlujo.contains(categoria)){
				categActual = categoria;
			}
		}
		
		//categoría a asignar al contenido.
		AssetCategory categSiguiente = null;
		//Si tenemos la categoría del contenido
		if (categActual == null){
			System.out.println("El contenido no tiene asociada categoria de FLUJO DE DOLICITUD");
			System.out.println("Se le añadirá el primer estado del FLUJO DE DOLICITUD");
		}
		
		//Tiene asociada una categoria de flujo
		//Le asociamos la siguiente al flujo
		categSiguiente = this.getSiguienteFlujo(categActual, categoriasFlujo);
		System.out.println("Se le añade el siguiente estado del FLUJO DE DOLICITUD:: '" + categSiguiente.getName() + "'");
		  
		//TODO
		//Asignar la categoría siguiente al articulo actual.
		AssetEntry entry = AssetEntryLocalServiceUtil.fetchEntry(JournalArticle.class.getName(), journalArticle.getResourcePrimKey());
		//añadimos la nueva categoría
		AssetCategoryLocalServiceUtil.addAssetEntryAssetCategory(entry.getEntryId(), categSiguiente);
		//eliminamos la anterior (si la hubiera)
		if (categActual != null){
			AssetCategoryLocalServiceUtil.deleteAssetEntryAssetCategory(entry.getEntryId(), categActual);
		}
		
		//Recogemos los datos necesarios para crear el anuncio
		//Usuario actual (el que ha publicado el artículo).
		long userId = journalArticle.getUserId();
			
		
		//dia de expiración
		Calendar calExpire = Calendar.getInstance();
		calExpire.set(Calendar.MONTH, 11);
		//dia actual
		Calendar calHoy = Calendar.getInstance();
		
		//ClassNameId del anuncio a crear
		//EJEMPLO DE ROL
		RoleServiceUtil roleUtil = new RoleServiceUtil();
		Role rol = roleUtil.getRole(journalArticle.getCompanyId(), "User");
		long classNameId = rol.getClassNameId();
		long classPK = rol.getClassPK();
		String title = "Cambio categoría contenido";
		String url = "";
		//boolean displayImmediately = true;
		
		
		/*
		 * CREAMOS EL ANUNCIO (FORMA 1) (ALARMA)
		 */
		AnnouncementsEntry nuevoAnuncio = null;
		AnnouncementsEntryPersistence anunPers = AnnouncementsEntryUtil.getPersistence();
		//Obtenemos el ID del artículo a crear
		long id = CounterLocalServiceUtil.getService().increment();
		System.out.println("Id obtenido=" + id);
		nuevoAnuncio = anunPers.create(id);
		//Vamos añadiendo datos al nuevo anuncio
		nuevoAnuncio.setUserId(userId);
		nuevoAnuncio.setClassNameId(classNameId);
		nuevoAnuncio.setClassPK(classPK);
		nuevoAnuncio.setCompanyId(journalArticle.getCompanyId());
		nuevoAnuncio.setTitle(title);
		if (categActual == null){
			nuevoAnuncio.setContent("El contenido ha pasado al primer estado del flujo :: " + categSiguiente.getName());
		}
		else {
			nuevoAnuncio.setContent("El contenido ha pasado del estado " + categActual.getName() 
									+ " al estado " + categSiguiente.getName());
		}
		
		nuevoAnuncio.setUrl(url);
		nuevoAnuncio.setType("general");
		nuevoAnuncio.setDisplayDate(calHoy.getTime());
		nuevoAnuncio.setExpirationDate(calExpire.getTime());
		nuevoAnuncio.setPriority(1);
		nuevoAnuncio.setAlert(false);
				
		//Creamos el anuncio
		anunPers.update(nuevoAnuncio);
		anunPers.clearCache();
		
		/*
		 * CREAMOS EL ANUNCIO (FORMA 2) (ANUNCIO)
		 */
		
		//Inicimos el servicio
		//this.cytedAnnounceService = new CytedAnnouncementsEntryLocalService(AnnouncementsEntryLocalServiceUtil.getService());
		
		//AnnouncementsEntryLocalServiceUtil anuncioLocalService = new AnnouncementsEntryLocalServiceUtil();   
		//AnnouncementsEntryLocalService anuncioService = anuncioLocalService.getService();
		//Título
		//title = "Título de prueba de creación de ANUNCIO desde Hook (2)";
		
		//AnnouncementsEntry anuncio = this.cytedAnnounceService.addEntry(userId, classNameId, classPK, title, content, url, 
		//		type, displayDateMonth, displayDateDay, displayDateYear, displayDateHour, displayDateMinute, displayImmediately, 
		//		calExpire.get(Calendar.MONTH), calExpire.get(Calendar.DAY_OF_MONTH),calExpire.get(Calendar.YEAR), calExpire.get(Calendar.HOUR),
		//		calExpire.get(Calendar.MINUTE), 1, false);
	
		//this.cytedAnnounceService.addAnnouncementsEntry(anuncio);
		
		System.out.println("updateArticle------------------------------ 2");
		System.out.println("IdArticle=" + articleId);
		System.out.println("Usuario actual=" + journalArticle.getUserId());
		System.out.println("folderId=" + folderId);
		System.out.println("journalArticle=" + journalArticle.getContent().toString());
		//System.out.println("journalArticle=" + journalArticle.getContent().
		System.out.println("journalArticle=" + journalArticle.buildTreePath());
		System.out.println("journalArticle=" + journalArticle.getTitle());
		
		System.out.println("------------------------------------------");
		System.out.println("IdEntry anuncio creado = " + nuevoAnuncio.getEntryId());
			
	
		
	    
		
		return journalArticle;
	}

	@Override
	public JournalArticle updateArticle(long groupId, long folderId, String articleId, double version, String content,
			ServiceContext serviceContext) throws PortalException, SystemException {
		// TODO Auto-generated method stub
		JournalArticle journalArticle =  super.updateArticle(groupId, folderId, articleId, version, content, serviceContext);
		System.out.println("updateArticle------------------------------ 3");
		System.out.println("IdArticle=" + articleId);
		System.out.println("folderId=" + folderId);
		
		return journalArticle;
	}

	@Override
	public JournalArticle updateArticleTranslation(long groupId, String articleId, double version, Locale locale,
			String title, String description, String content, Map<String, byte[]> images, ServiceContext serviceContext)
			throws PortalException, SystemException {
		// TODO Auto-generated method stub
		JournalArticle journalArticle =  super.updateArticleTranslation(groupId, articleId, version, locale, title, description, content, images,
				serviceContext);
		
		
		System.out.println("updateArticleTranslation------------------------------");
		System.out.println("IdArticle=" + articleId);
		
		return journalArticle;
	}
	
	
	
	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public  com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public  void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}
	
	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public  com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public  void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}
	
	
	/**
	 * Returns the journal article persistence.
	 *
	 * @return the journal article persistence
	 */
	public  JournalArticlePersistence getJournalArticlePersistence() {
		return journalArticlePersistence;
	}

	/**
	 * Sets the AnnouncementsEntry persistence.
	 *
	 * @param AnnouncementsEntryPersistence the announcements entry persistence
	 */
	public  void setAnnouncementsEntryPersistence(
			AnnouncementsEntryPersistence announcementsEntryPersistence) {
		this.announcementsEntryPersistence = announcementsEntryPersistence;
	}
	
	
	/**
	 * Returns the AnnouncementsEntry persistence.
	 *
	 * @return the AnnouncementsEntry persistence
	 */
	public  AnnouncementsEntryPersistence getAnnouncementsEntryPersistence() {
		return announcementsEntryPersistence;
	}

	/**
	 * Sets the journal article persistence.
	 *
	 * @param journalArticlePersistence the journal article persistence
	 */
	public  void setJournalArticlePersistence(
		JournalArticlePersistence journalArticlePersistence) {
		this.journalArticlePersistence = journalArticlePersistence;
	}
	
	
	

}