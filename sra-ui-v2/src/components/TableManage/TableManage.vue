<template>
  <div>
    <n-card>
      <div class="tm-search">
        <n-form :inline="true" label-placement="left">
          <div style="display: flex; flex-wrap: wrap">
            <slot name="search"></slot>
          </div>
        </n-form>
      </div>
      <div class="tm-operate">
        <slot name="operate"></slot>
      </div>
    </n-card>

    <n-card style="margin-top: 3px">
      <n-space>
        <slot name="default"></slot>
      </n-space>
    </n-card>

    <div>
      <slot name="form"></slot>
    </div>
  </div>
</template>
