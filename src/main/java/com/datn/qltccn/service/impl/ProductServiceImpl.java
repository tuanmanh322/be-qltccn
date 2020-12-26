//package com.datn.qltccn.service.impl;
//
//import com.kl.jewelry.dao.AutoCompleteDAO;
//import com.kl.jewelry.dao.ProductCustom;
//import com.kl.jewelry.dto.*;
//import com.kl.jewelry.model.*;
//import com.kl.jewelry.repository.*;
//import com.kl.jewelry.service.FileStorageService;
//import com.kl.jewelry.service.ProductService;
//import org.apache.commons.lang3.StringUtils;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.io.IOException;
//import java.util.Date;
//import java.util.List;
//
//@Service
//@Transactional
//public class ProductServiceImpl implements ProductService {
//    private final ProductRepository productRepository;
//
//    private final ModelMapper modelMapper;
//
//    private final ProductCustom productCustom;
//
//    private final ColorRepository colorRepository;
//
//    private final TrademarkRepository trademarkRepository;
//
//    private final CategoryRepository categoryRepository;
//
//    private final SaleRepository saleRepository;
//
//    private final FileStorageService fileStoreService;
//
//    private final AutoCompleteDAO autoCompleteDAO;
//
//    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ProductCustom productCustom, ColorRepository colorRepository, TrademarkRepository trademarkRepository, CategoryRepository categoryRepository, SaleRepository saleRepository, FileStorageService fileStoreService, AutoCompleteDAO autoCompleteDAO) {
//        this.productRepository = productRepository;
//        this.modelMapper = modelMapper;
//        this.productCustom = productCustom;
//        this.colorRepository = colorRepository;
//        this.trademarkRepository = trademarkRepository;
//        this.categoryRepository = categoryRepository;
//        this.saleRepository = saleRepository;
//        this.fileStoreService = fileStoreService;
//        this.autoCompleteDAO = autoCompleteDAO;
//    }
//
//    @Override
//    public List<Product> getAllIndex() {
//        return productCustom.getAllIndex();
//    }
//
//    @Override
//    public ProductDetailDTO findByDetail(Long id) {
//        Product product = productRepository.getOne(id);
//        ProductDetailDTO dto = modelMapper.map(product, ProductDetailDTO.class);
//
//        if (product.getIdCategory() != null) {
//            Category category = categoryRepository.getOne(product.getIdCategory());
//            dto.setCategoryName(category.getName());
//        }
//        if (product.getIdColor() != null) {
//            Color color = colorRepository.getOne(product.getIdColor());
//            dto.setColorName(color.getName());
//        }
//        if (product.getIdMark() != null) {
//            Trademark trademark = trademarkRepository.getOne(product.getIdMark());
//            dto.setMarkName(trademark.getNameProduct());
//            dto.setDescriptionMark(trademark.getDescription());
//        }
//        if (product.getIdSale() != null) {
//            Sale sale = saleRepository.getOne(product.getIdSale());
//            dto.setCodeSale(sale.getCode());
//            dto.setNameSale(sale.getName());
//        }
//        return dto;
//    }
//
//    @Override
//    public void addNewProduct(ProductDTO productDTO) {
//        Product product = modelMapper.map(productDTO, Product.class);
//        if (productDTO.getImageFile() != null) {
//            try {
//                product.setImageProduct(fileStoreService.storeFile(productDTO.getImageFile()));
//            } catch (IOException ignored) {
//
//            }
//        }
//        product.setSellCount(0);
//        product.setCreatedDate(new Date());
//        productRepository.save(product);
//    }
//
//    @Override
//    public void edit(ProductDTO productDTO) {
//        Product product = productRepository.getOne(productDTO.getId());
//        if (productDTO.getImageFile() != null) {
//            try {
//                product.setImageProduct(fileStoreService.storeFile(productDTO.getImageFile()));
//            } catch (IOException ignored) {
//
//            }
//        }
//        if (StringUtils.isNotBlank(productDTO.getDescription())) {
//            product.setDescription(productDTO.getDescription());
//        }
//        if (StringUtils.isNotBlank(productDTO.getName())) {
//            product.setName(productDTO.getName());
//        }
//        if (StringUtils.isNotBlank(productDTO.getMaSp())) {
//            product.setMaSp(productDTO.getMaSp());
//        }
//        product.setIdCategory(productDTO.getIdCategory());
//        product.setIdColor(productDTO.getIdColor());
//        product.setIdMark(productDTO.getIdMark());
//        if (StringUtils.isNotBlank(productDTO.getISale())){
//            Long a = Long.parseLong(productDTO.getISale());
//            product.setIdSale(Long.parseLong(productDTO.getISale()));
//        }
//        if (productDTO.getSellCount() != null) {
//            product.setSellCount(product.getSellCount() + productDTO.getSellCount());
//        }
//        productRepository.save(product);
//    }
//
//    @Override
//    public void delete(Long id) {
//        productRepository.deleteById(id);
//    }
//
//    @Override
//    public List<Product> getRelativeProduct(Long idCategory, Long idColor) {
//        return productRepository.findByIdCategoryAndIdColor(idCategory, idColor);
//    }
//
//    @Override
//    public List<ProductListSaleDTO> getAllIndexSale() {
//        return productCustom.getAllIndexSale();
//    }
//
//    @Override
//    public List<ProductListSaleDTO> getAllRelative(ProductListSaleDTO dto) {
//        return productCustom.getAllSaleRelative(dto);
//    }
//
//    @Override
//    public void productSearchDto(ProductSearchDTO dto) {
//        productCustom.searchProduct(dto);
//    }
//
//    @Override
//    public List<AutoCompleteTitleSet> autoComplete(AutocompleteSearchDTO dto) {
//        return autoCompleteDAO.searchTitleProduct(dto);
//    }
//
//
//}
