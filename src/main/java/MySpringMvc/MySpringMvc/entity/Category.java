package MySpringMvc.MySpringMvc.entity;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.Serializable;
import java.sql.Blob;
@Entity
@Table(name="category")
public class Category implements Serializable{

	
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "categoryId")
		int categoryId;

		@Column(name = "categoryName")
		String categoryName;

/*
		@Transient
		private CommonsMultipartFile photo;   //for DataBinder to bind <input type="file".../>
											  //will not be mapped for Hibernate as we store the file in the FileSystem
											  //file will be placed into this field by DataBinder
											  //file is in the memory. needs to be transferred to the FileSystem using java.io.file
		@Column(name = "filename")
		private String filename;   



		public CommonsMultipartFile getPhoto() {
			return photo;
		}

		public void setPhoto(CommonsMultipartFile photo) {
			this.photo = photo;
		}

		public String getFilename() {
			return filename;
		}

		public void setFilename(String filename) {
			this.filename = filename;
		}
*/
		public Category(String categoryName)
		{
			this.categoryName=categoryName;
			//this.filename=fileName;
		}
		
		public Category()
		{}
		public int getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}

		public String getCategoryName() {
			return categoryName;
		}

		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}

		
	}
