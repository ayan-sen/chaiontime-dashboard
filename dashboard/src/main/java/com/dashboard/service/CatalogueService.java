package com.dashboard.service;

import java.util.List;

import javassist.tools.rmi.ObjectNotFoundException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.dashboard.model.Catalogue;
import com.dashboard.model.Product;
import com.dashboard.repository.CatalogueRepository;

@Service
public class CatalogueService {

	@Resource
	private CatalogueRepository catalogueRepository;
	
	public String add(Catalogue catalogue) {
		List<Product> products = catalogue.getProducts();
		if(!CollectionUtils.isEmpty(products))
			products.forEach(p -> p.setCatalogue(catalogue));
		return catalogueRepository.add(catalogue);
	}

	public List<Catalogue> getAll() {
		List<Catalogue> catalogs = catalogueRepository.getAll();
		catalogs.stream().forEach(c -> c.getProducts().removeIf(p -> p.getActive().equals("0")));
		return catalogs;
	}

	public Catalogue getById(String id) throws ObjectNotFoundException {
		Catalogue catalogue = catalogueRepository.getById(id);
		if(catalogue == null) {
			throw new ObjectNotFoundException("Catalogue is not found for id :" + id);
		}
		if(catalogue != null && catalogue.getActive().equals("0")) {
			throw new ObjectNotFoundException("Catalogue is not found for id :" + id);
		}
		catalogue.getProducts().removeIf(p -> p.getActive().equals("0"));
		return catalogue;
	}

	public String updateById(Catalogue catalogue) {
		List<Product> products = catalogue.getProducts();
		if(!CollectionUtils.isEmpty(products))
			products.forEach(p -> p.setCatalogue(catalogue));
		return catalogueRepository.updateById(catalogue);
	}

	public String deleteById(String id) throws ObjectNotFoundException {
		Catalogue catalogue = this.getById(id);
		return catalogueRepository.deleteById(catalogue);
	}

	public Product getProductById(String id) throws ObjectNotFoundException {
		Product product = catalogueRepository.getProductById(id);
		if(product == null) {
			throw new ObjectNotFoundException("Product is not found for id :" + id);
		}
		if(product != null && product.getActive().equals("0")) {
			throw new ObjectNotFoundException("Product is not found for id :" + id);
		}
		return product;
	}
	
	public String deleteProductById(Long id) {
		return catalogueRepository.deleteProductById(id);
	}
}
