//package com.datn.qltccn.dao.impl;
//
//import com.kl.jewelry.dao.ProductCustom;
//import com.kl.jewelry.dto.ProductFinalDTO;
//import com.kl.jewelry.dto.ProductListSaleDTO;
//import com.kl.jewelry.dto.ProductSearchDTO;
//import com.kl.jewelry.model.Product;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//import org.springframework.util.CollectionUtils;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Repository
//public class ProductCustomImpl extends AbstractDAO implements ProductCustom {
//    @Override
//    public List<Product> getAllIndex() {
//        return getSession().createQuery("SELECT  p from Product p order by p.createdDate DESC ").setMaxResults(8).getResultList();
//    }
//
//    @Override
//    public List<ProductListSaleDTO> getAllIndexSale() {
//        StringBuilder sb = new StringBuilder();
//        Map<String, Object> parameters = new HashMap<>();
//        sb.append(" SELECT p.id as id, p.name as name, p.ma_sp as maSp, p.image_product as imageProduct, p.price as price, p.sell_count as  ");
//        sb.append(" sellCount, sale.`name` as saleName, sale.code as codeSale , p.id_sale  as idSale, p.id_color as idColor, p.id_mark as idMark, p.id_category as idCategory ");
//        sb.append(" from jewelry.product as p left join jewelry.sale as sale on p.id_sale = sale.id ");
//        sb.append(" WHERE p.id_sale is not null  ");
//        sb.append(" ORDER BY p.created_date DESC ");
//        ((JdbcTemplate) namedParameterJdbcTemplate().getJdbcOperations()).setMaxRows(10);
//        return namedParameterJdbcTemplate().query(sb.toString(), parameters, BeanPropertyRowMapper.newInstance(ProductListSaleDTO.class));
//    }
//
//    @Override
//    public List<ProductListSaleDTO> getAllSaleRelative(ProductListSaleDTO dto) {
//        StringBuilder sb = new StringBuilder();
//        Map<String, Object> parameters = new HashMap<>();
//        sb.append(" SELECT p.id as id, p.name as name, p.ma_sp as maSp, p.image_product as imageProduct, p.price as price, p.sell_count as  ");
//        sb.append(" sellCount, sale.`name` as saleName, sale.code as codeSale , p.id_sale  as idSale, p.id_color as idColor, p.id_mark as idMark, p.id_category as idCategory ");
//        sb.append(" from jewelry.product as p left join jewelry.sale as sale on p.id_sale = sale.id");
//        sb.append(" WHERE 1 = 1  ");
//        if (dto.getIdCategory() != null){
//            sb.append(" and p.id_category =:p_idcategory");
//            parameters.put("p_idcategory", dto.getIdCategory());
//        }
//        if (dto.getIdColor() != null){
//            sb.append(" and p.id_color =:p_idcorlor");
//            parameters.put("p_idcorlor", dto.getIdColor());
//        }
//        if (dto.getIdMark() != null){
//            sb.append(" and p.id_mark =:p_idmark");
//            parameters.put("p_idmark", dto.getIdMark());
//        }
//        if (dto.getIdSale() != null){
//            sb.append(" and p.id_sale =:p_idsale");
//            parameters.put("p_idsale", dto.getIdSale());
//        }
//        sb.append(" ORDER BY p.created_date DESC ");
//        ((JdbcTemplate) namedParameterJdbcTemplate().getJdbcOperations()).setMaxRows(10);
//        return namedParameterJdbcTemplate().query(sb.toString(), parameters, BeanPropertyRowMapper.newInstance(ProductListSaleDTO.class));
//
//    }
//
//    @Override
//    public void searchProduct(ProductSearchDTO dto) {
//        final StringBuilder sb = new StringBuilder();
//        Map<String, Object> parameters = new HashMap<>();
//
//        sb.append(" select distinct ");
//        sb.append(" p.id as id,");
//        sb.append(" p.created_date as createDate,");
//        sb.append(" p.description as description,");
//        sb.append(" p.id_category as idCategory,");
//        sb.append(" p.id_color as idColor,");
//        sb.append(" p.id_mark as idMark,");
//        sb.append(" p.id_sale as idSale,");
//        sb.append(" p.image_product as imageProduct,");
//        sb.append(" p.ma_sp as maSP, ");
//        sb.append(" p.`name` as nameSP, ");
//        sb.append(" p.price as price, ");
//        sb.append(" p.sell_count as sellCount, ");
//        sb.append(" p.total_item as totalItem, ");
//        sb.append(" sal.`code` as codeSale ");
//        sb.append(" from ");
//        sb.append(" jewelry.product as p  ");
//        sb.append(" left join jewelry.sale as sal on p.id_sale =sal.id ");
//        sb.append(" where 1 = 1 ");
//        if (StringUtils.isNotBlank(dto.getName())) {
//            sb.append(" and p.name like :p_name");
//            parameters.put("p_name", "%" + dto.getName().trim() + "%");
//        }
//        if (!CollectionUtils.isEmpty(dto.getIdCategory())) {
//            sb.append(" and p.id_category in (:p_id_category_list) ");
//            parameters.put("p_id_category_list", dto.getIdCategory());
//        }
//        if (!CollectionUtils.isEmpty(dto.getIdColor())) {
//            sb.append(" and p.id_color in (:p_id_color_list) ");
//            parameters.put("p_id_color_list", dto.getIdColor());
//        }
//        if (!CollectionUtils.isEmpty(dto.getIdMark())) {
//            sb.append(" and p.id_mark in (:p_id_mark_list)");
//            parameters.put("p_id_mark_list", dto.getIdMark());
//        }
//        if (!CollectionUtils.isEmpty(dto.getIdSale())) {
//            sb.append(" and p.id_sale in (:p_id_sale_list)");
//            parameters.put("p_id_sale_list", dto.getIdSale());
//        }
//
//        if (dto.getPriceFirst() != null) {
//            sb.append(" and p.price >= :p_pricefirst ");
//            parameters.put("p_pricefirst", dto.getPriceFirst());
//        }
//        if (dto.getPriceFirst() != null) {
//            sb.append(" and p.price <= :p_pricesecond ");
//            parameters.put("p_pricesecond", dto.getPriceSecond());
//        }
//        sb.append(" group by p.id , p.created_date  , p.description , p.id_category ,p.id_color ,p.id_mark ,p.id_sale,p.image_product,p.ma_sp, ");
//        sb.append(" p.`name`,p.price,p.sell_count ,p.total_item, sal.`code` ");
//        if (!CollectionUtils.isEmpty(dto.getOrders())) {
//            sb.append(" order by ");
//            dto.getOrders().forEach(order -> {
//                String property = StringUtils.trimToEmpty(order.getProperty());
//                switch (property) {
//                    case "newest":
//                        sb.append(" p.price desc");
//                        break;
//                    case "oldest":
//                        sb.append(" p.price asc");
//                        break;
//                    case "random":
//                        sb.append(" rand() ");
//                        break;
//                }
//            });
//        } else {
//            sb.append(" order by p.created_date desc");
//        }
//        searchAndCountTotal(dto, sb.toString(), parameters, ProductFinalDTO.class);
//    }
//}
