import {
  LitElement,
  html,
  query,
  property,
  customElement,
} from "lit-element";
import '@vaadin/vaadin-text-field/vaadin-text-field.js';
import "@vaadin/vaadin-text-field/vaadin-password-field.js";
import '@vaadin/vaadin-button/vaadin-button.js';
// @ts-ignore
import * as glyphs from "./vaadin-icons-bundle.js";


@customElement("login-view")
export class LoginView extends LitElement {
  @property()
  label: String | undefined = undefined;

  @query("#loginForm")
  loginForm!: HTMLFormElement;

  createRenderRoot() {
    return this;
  }

  render() {
    return html`
      <div
        class="flex flex-grow login-view-wrapper items-center justify-center"
      >
        <div
          class="border border-contrast-20 flex flex-col rounded-m bg-base p-m"
        >
          <form id="loginForm" name="login" method="POST" action="login" class="flex flex-col">
            <vaadin-text-field
              name="username"
              label="Your user name"
              autocapitalize="none"
              autocorrect="off"
              spellcheck="false"
            >
              <input type="text" slot="input" />
            </vaadin-text-field>

            <vaadin-button
              theme="primary contained"
              @click=${() => this.submit()}
              >Submit</vaadin-button
            >
          </form>
        </div>
      </div>

      <div class="image-attribution p-s">
        Image by
        <a href="https://flickr.com/photos/wrack/28987657184">Wegdekstreepje</a>
      </div>
    `;
  }

  constructor() {
    super();
  }

  connectedCallback() {
    super.connectedCallback();
  }

  submit() {
    this.loginForm.submit();
  }
}